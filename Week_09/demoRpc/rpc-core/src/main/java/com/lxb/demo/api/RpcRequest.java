package com.lxb.demo.api;

import lombok.Data;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:25
 * @Description:
 */
@Data
public class RpcRequest {

    private String serviceClass;
    private String method;
    private Object[] argv;
}
