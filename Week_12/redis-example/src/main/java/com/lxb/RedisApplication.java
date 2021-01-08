package com.lxb;

import com.alibaba.fastjson.JSON;
import com.lxb.sentinel.SentinelJedis;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @author lixiaobing
 * @date 2021-01-06 15:38
 * @Description:
 */
@SpringBootApplication
public class RedisApplication {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {

    }

    private void jedisClient() {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.info());
        jedis.set("uptime", new Long(System.currentTimeMillis()).toString());
        System.out.println(jedis.get("uptime"));
    }

    private void jedisSentinnel() {
        Jedis sjedis = SentinelJedis.getJedis();
        System.out.println(sjedis.info());
        sjedis.set("uptime2", new Long(System.currentTimeMillis()).toString());
        System.out.println(sjedis.get("uptime2"));
        SentinelJedis.close();

    }

    private void jedisSentinel() {
        Jedis                     jedis = new Jedis("localhost", 16381);
        List<Map<String, String>> maps  = jedis.sentinelMasters();
        System.out.println(JSON.toJSON(maps));
        List<Map<String, String>> slaves = jedis.sentinelSlaves("mymaster");
        System.out.println(JSON.toJSONString(slaves));
    }

    private void lettuceClient() {
        RedisClient                             redisClient = RedisClient.create("redis://192.168.101.104:6381/");
        StatefulRedisConnection<String, String> connection  = redisClient.connect();
        System.out.println(connection.toString());
        RedisCommands<String, String> sync = connection.sync();
        sync.set("key", "Hello, Lettuce Redis");
        System.out.println(sync.get("key"));
    }

    public void lettuceSentinel() {
        RedisURI redisURI = RedisURI.Builder
                .sentinel("192.168.101.104", 16381)
                .withSentinelMasterId("mymaster")
                .build();
        RedisClient                             client     = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = client.connect();
        System.out.println(connection.toString());

        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "Hello, Lettuce Redis");
        System.out.println(syncCommands.get("key"));

    }

    private void redissionClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.101.104:6379");
        RedissonClient       client = Redisson.create(config);
        RMap<String, String> map    = client.getMap("map");
        map.put("test", "test");
        System.out.println(map.toString());
    }
    private void redissionSentinel() {
        Config config = new Config();
        config.useSentinelServers().addSentinelAddress("redis://192.168.101.104:16379");
        RedissonClient client = Redisson.create(config);
        RMap<String, String> map = client.getMap("map");
        map.put("test", "test");
        System.out.println(map.toString());
    }

    private void springRedisSentinel() {
        redisTemplate.opsForValue().set("test", "test");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }


}
