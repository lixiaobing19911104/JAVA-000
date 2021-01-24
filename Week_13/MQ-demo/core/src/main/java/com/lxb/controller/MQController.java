package com.lxb.controller;

import com.lxb.queue.Broker;
import com.lxb.queue.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lixiaobing
 * @date 2021-01-24 11:57
 * @Description:
 */
@RestController
public class MQController {
    private final Broker broker;

    public MQController(Broker broker) {
        this.broker = broker;
    }

    @PostMapping("/send")
    public boolean send(@RequestBody Message message) {
        return broker.send(message.getTopic(), message.getContent());
    }

    @GetMapping("/poll")
    public List poll(@RequestParam(value = "topic") String topic,
                     @RequestParam(value = "rate") Integer rate) {
        return broker.poll(topic, rate);
    }

}
