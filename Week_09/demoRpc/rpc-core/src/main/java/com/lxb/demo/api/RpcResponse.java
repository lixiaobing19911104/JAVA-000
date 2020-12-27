package com.lxb.demo.api;

import lombok.Data;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:26
 * @Description:
 */
@Data
public class RpcResponse {
    private Object    result;
    private Boolean   status;
    private Exception exception;
}
