package com.lxb.demo.exception;

import lombok.NoArgsConstructor;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:28
 * @Description:
 */
@NoArgsConstructor
public class RpcException extends RuntimeException {
    private String message;

    public RpcException(String message) {
        super(message);
        this.message = message;
    }

}
