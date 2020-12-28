package com.lxb.demo.api;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:24
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
public class RpcProviderDesc {
    String  serviceName;
    String  host;
    Integer port;
    String  group;
    String  version;
    String  id;

    public RpcProviderDesc(String serviceName, String host, Integer port, String group, String version, String id) {
        this.serviceName = serviceName;
        this.host        = host;
        this.port        = port;
        this.group       = group;
        this.version     = version;
        this.id          = id;
    }
}
