package com.lxb.demo.netty.common;

import lombok.Data;

/**
 * @author lixiaobing
 * @date 2020-12-27 20:53
 * @Description:
 */
@Data
public class RpcProtocol {
    private int    len;
    private byte[] content;
}
