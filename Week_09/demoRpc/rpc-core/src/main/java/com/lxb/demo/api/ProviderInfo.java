package com.lxb.demo.api;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:30
 * @Description:
 */
@Data
@NoArgsConstructor
public class ProviderInfo {
    private String id;
    private String url;

    public ProviderInfo(String id, String url) {
        this.id  = id;
        this.url = url;
    }
}
