package com.lxb.demo.discovery;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:34
 * @Description:
 */
@Slf4j
public class ZookeeperClient {
    protected static final String           REGISTER_ROOT_PATH = "rpc";
    protected            CuratorFramework curatorFramework;

    ZookeeperClient() {
        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(1000, 3);
        this.curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .namespace(REGISTER_ROOT_PATH)
                .retryPolicy(exponentialBackoffRetry)
                .build();
        this.curatorFramework.start();
        log.info("zookeeper service register init");

    }
}
