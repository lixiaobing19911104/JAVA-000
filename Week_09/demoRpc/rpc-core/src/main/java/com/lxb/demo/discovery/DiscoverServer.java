package com.lxb.demo.discovery;

import com.google.common.base.Joiner;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:39
 * @Description:
 */
public class DiscoverServer extends ZookeeperClient {
    List<ServiceDiscovery<String>> discoveryList = new ArrayList<>();

    public DiscoverServer() {
    }

    public void registerService(String service, String group, String version, int port) throws Exception {
        ServiceInstance<String> instance = ServiceInstance.<String>builder()
                .name(Joiner.on(":").join(service, group, version))
                .port(port)
                .address(InetAddress.getLocalHost().getHostAddress())
                .build();
        ServiceDiscovery<String> discovery = ServiceDiscoveryBuilder.builder(String.class)
                .client(curatorFramework)
                .basePath(REGISTER_ROOT_PATH)
                .thisInstance(instance)
                .build();
        discovery.start();
        discoveryList.add(discovery);

    }

    public void close() throws IOException {
        for (ServiceDiscovery<String> discovery : discoveryList) {
            discovery.close();
        }
        this.curatorFramework.close();

    }
}
