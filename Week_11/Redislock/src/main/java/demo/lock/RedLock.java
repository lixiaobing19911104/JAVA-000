package demo.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * @author lixiaobing
 * @date 2020-12-31 15:04
 * @Description:
 */
public class RedLock {

    public static boolean lock(JedisPool jedisPool, String lock, int seconds) {
        try (Jedis jedis = jedisPool.getResource()) {
            return "OK".equals(jedis.set(lock, lock, "NX", "EX", seconds));
        }
    }

    public static boolean release(JedisPool jedisPool, String lock) {
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then " + "return redis.call('del',KEYS[1]) else return 0 end";
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.eval(luaScript, Collections.singletonList(lock), Collections.singletonList(lock)).equals(1L);
        }
    }
}
