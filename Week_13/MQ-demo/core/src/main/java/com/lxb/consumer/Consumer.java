package com.lxb.consumer;

import java.util.List;

/**
 * @author lixiaobing
 * @date 2021-01-24 11:58
 * @Description:
 */
public interface Consumer {
    List poll(String topic, int rate);

}
