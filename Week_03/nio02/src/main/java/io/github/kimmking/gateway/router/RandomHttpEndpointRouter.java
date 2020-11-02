package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lixiaobing
 * @date 2020-11-02 15:59
 * @Description:
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public String route(List<String> endpoints) {
        return endpoints.get(random.nextInt(endpoints.size()));
    }
}
