package io.github.kimmking.gateway.router;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author lixiaobing
 * @date 2020-11-02 16:02
 * @Description:
 */
public class HttpEndpointRouterFactory {
    private ConcurrentMap<RouterTypeEnum, HttpEndpointRouter> routers = new ConcurrentHashMap<>();

    {
        routers.put(RouterTypeEnum.RANDOM, new RandomHttpEndpointRouter());
        routers.put(RouterTypeEnum.ROUND_ROBIN, new RoundRobinHttpEndpointRouter());
    }

    HttpEndpointRouter getByType(RouterTypeEnum routerType) {
        return routers.get(routerType);
    }

    HttpEndpointRouter getDefault() {
        return new RoundRobinHttpEndpointRouter();
    }


}
