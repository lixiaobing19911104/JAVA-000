package com.lxb.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author lixiaobing
 * @date 2021-01-24 11:54
 * @Description:
 */
@Component
@Slf4j
public class Broker {
    Map<String, ConcurrentLinkedQueue> queueMap = new HashMap<>();

    public boolean send(String topic, String content) {
//        log.info("receive message : " + content + " from topic : " + topic);

        if (!queueMap.containsKey(topic)) {
            queueMap.put(topic, new ConcurrentLinkedQueue());
        }

        queueMap.get(topic).add(content);

        return true;
    }

    public List<String> poll(String topic, int rate) {
//        log.info("poll data to : " + topic);

        ConcurrentLinkedQueue queue = queueMap.get(topic);

        List<String> messages = new ArrayList<>();
        if (queue == null) {
            return messages;
        }

        log.info("queue message amount : " + queue.size());
        while (!queue.isEmpty() || rate > 0) {
            messages.add(Objects.requireNonNull(queue.poll()).toString());
            rate -= 1;
        }

        return messages;
    }

}
