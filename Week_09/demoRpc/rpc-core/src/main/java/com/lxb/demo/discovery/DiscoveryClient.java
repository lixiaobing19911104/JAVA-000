package com.lxb.demo.discovery;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.lxb.demo.api.ProviderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:47
 * @Description:
 */
@Slf4j
public class DiscoveryClient extends ZookeeperClient {
    private       Map<String, List<ProviderInfo>> providerCache = new HashMap<>();
    private final ServiceDiscovery<String>        serviceDiscovery;
    private final CuratorCache                    resourcesCache;

    public DiscoveryClient()  {
        serviceDiscovery = ServiceDiscoveryBuilder.builder(String.class)
                .client(curatorFramework)
                .basePath("/" )
                .build();
        try {
            serviceDiscovery.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            getAllProviders();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.resourcesCache = CuratorCache.build(this.curatorFramework, "/");
        watchResources();

    }

    private void getAllProviders() throws Exception {
        System.out.println("\n\n======================= init : get all provider");
        Collection<String> serviceNames = serviceDiscovery.queryForNames();
        System.out.println(serviceNames.size() + " type(s)");
        for (String serviceName : serviceNames) {
            Collection<ServiceInstance<String>> instances = serviceDiscovery.queryForInstances(serviceName);
            for (ServiceInstance<String> instance : instances) {
                String             url          = "http://" + instance.getAddress() + ":" + instance.getPort();
                ProviderInfo       providerInfo = new ProviderInfo(instance.getId(), url);
                List<ProviderInfo> providerList = providerCache.getOrDefault(instance.getName(), new ArrayList<>());
                providerList.add(providerInfo);
                providerCache.put(instance.getName(), providerList);
                System.out.println("add provider: " + instance.toString());
            }
        }
        System.out.println();
        for (String key : providerCache.keySet()) {
            System.out.println(key + " : " + providerCache.get(key));
        }

    }

    private void watchResources() {
        CuratorCacheListener listener = CuratorCacheListener.builder()
                .forCreates(this::addProvider)
                .forChanges(this::updateProvider)
                .forDeletes(this::deleteProvider)
                .forInitialized(() -> {
                    log.info("Resources Cache initialized");
                })
                .build();
        resourcesCache.listenable().addListener(listener);
        resourcesCache.start();
    }

    private void addProvider(ChildData node) {
        System.out.println("\n\n=================== add new provider ============================");

        System.out.printf("Node created: [%s:%s]%n", node.getPath(), new String(node.getData()));
        if (providerDataEmpty(node)) {
            return;
        }

        String     jsonValue = new String(node.getData(), StandardCharsets.UTF_8);
        JSONObject instance  = (JSONObject) JSONObject.parse(jsonValue);
        System.out.println(instance.toString());

        String       url          = "http://" + instance.get("address") + ":" + instance.get("port");
        ProviderInfo providerInfo = new ProviderInfo(instance.get("id").toString(), url);

        List<ProviderInfo> providerList = providerCache.getOrDefault(instance.get("name").toString(), new ArrayList<>());
        providerList.add(providerInfo);
        providerCache.put(instance.get("name").toString(), providerList);

        System.out.println("=================== add new provider end ============================\n\n");
    }

    private boolean providerDataEmpty(ChildData node) {
        return node.getData().length == 0;
    }

    private void updateProvider(ChildData oldNode, ChildData newNode) {
        System.out.printf("Node changed, Old: [%s: %s] New: [%s: %s]%n", oldNode.getPath(),
                new String(oldNode.getData()), newNode.getPath(), new String(newNode.getData()));
    }

    private void deleteProvider(ChildData oldNode) {
        System.out.println("\n\n=================== delete provider ============================");

        System.out.printf("Node deleted, Old value: [%s: %s]%n", oldNode.getPath(), new String(oldNode.getData()));
        if (providerDataEmpty(oldNode)) {
            return;
        }

        String     jsonValue = new String(oldNode.getData(), StandardCharsets.UTF_8);
        JSONObject instance  = (JSONObject) JSONObject.parse(jsonValue);
        System.out.println(instance.toString());

        String provider    = instance.get("name").toString();
        int    deleteIndex = -1;
        for (int i = 0; i < providerCache.get(provider).size(); i++) {
            if (providerCache.get(provider).get(i).getId().equals(instance.get("id").toString())) {
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex != -1) {
            providerCache.get(provider).remove(deleteIndex);
        }

        System.out.println("=================== delete provider end ============================\n\n");
    }
    public String getProviders(String service, String group, String version) throws Exception {
        String provider = Joiner.on(":").join(service, group, version);
        if (!providerCache.containsKey(provider) || providerCache.get(provider).isEmpty()) {
            return null;
        }
        return providerCache.get(provider).get(0).getUrl();
    }



}
