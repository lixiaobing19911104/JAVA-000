package com.lxb.producer;

/**
 * @author lixiaobing
 * @date 2021-01-24 12:00
 * @Description:
 */
public interface Producer {
    void send(String topic, String message);

}
