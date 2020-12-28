package com.lxb.demo.proxy;

import com.google.common.base.Joiner;
import com.lxb.demo.annotation.RpcService;
import com.lxb.demo.api.RpcRequest;
import com.lxb.demo.discovery.DiscoverServer;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixiaobing
 * @date 2020-12-28 16:31
 * @Description:
 */
@Slf4j
public class ProviderServiceManagement {
    private static Map<String, Object> proxyMap = new HashMap<>();

    public static void init(String packageName, int port) throws Exception {
        System.out.println("\n-------- Loader Rpc Provider class start ----------------------\n");

        DiscoverServer serviceRegister = new DiscoverServer();

        Class[] classes = getClasses(packageName);
        for (Class c : classes) {
            RpcService annotation = (RpcService) c.getAnnotation(RpcService.class);
            if (annotation == null) {
                continue;
            }
            String group    = annotation.group();
            String version  = annotation.version();
            String provider = Joiner.on(":").join(annotation.service(), group, version);

            proxyMap.put(provider, c.newInstance());

            serviceRegister.registerService(annotation.service(), group, version, port);

            log.info("load provider class: " + annotation.service() + ":" + group + ":" + version + " :: " + c.getName());
        }
        System.out.println("\n-------- Loader Rpc Provider class end ----------------------\n");
    }

    public static Object getProviderService(RpcRequest request) {
        String group     = "default";
        String version   = "default";
        String className = request.getServiceClass();
        if (request.getGroup() != null) {
            group = request.getGroup();
        }
        if (request.getVersion() != null) {
            version = request.getVersion();
        }
        return proxyMap.get(Joiner.on(":").join(className, group, version));
    }

    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String           path      = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File>       dirs      = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[0]);
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }


}
