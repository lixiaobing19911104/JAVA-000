package com.lxb.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * @author lixiaobing
 * @date 2021-01-06 16:04
 * @Description:
 */
public class HazelcastDemo {
    public static void main(String[] args) {
//        singleDome();
        clusterDemo();
    }

    /**
     * 单节点简单操作演示
     */
    private static void singleDome() {
        HazelcastInstance     hazelcastInstance = Hazelcast.newHazelcastInstance();
        Map<Integer, Integer> map               = hazelcastInstance.getMap("data");
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
            System.out.println(map.get(i));
        }
        hazelcastInstance.shutdown();
    }

    private static void clusterDemo() {
        Config config = new Config();
        config.getGroupConfig().setName("group1");

        HazelcastInstance hazelcastInstance1 = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance hazelcastInstance2 = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance hazelcastInstance3 = Hazelcast.newHazelcastInstance(config);

        Map<Integer, Integer> map1 = hazelcastInstance1.getMap("data");
        Map<Integer, Integer> map2 = hazelcastInstance2.getMap("data");
        Map<Integer, Integer> map3 = hazelcastInstance3.getMap("data");

        for (int i = 0; i < 100; i++) {
            map1.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(map2.get(i));
            System.out.println(map3.get(i));
        }
    }


}
