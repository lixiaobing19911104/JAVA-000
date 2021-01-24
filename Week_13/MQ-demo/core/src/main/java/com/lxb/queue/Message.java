package com.lxb.queue;

import lombok.Data;

/**
 * @author lixiaobing
 * @date 2021-01-24 11:56
 * @Description:
 */
@Data
public class Message {
    private String topic;

    private String content;

    public Message(String topic, String content) {
        this.topic   = topic;
        this.content = content;
    }

}
