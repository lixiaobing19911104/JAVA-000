package com.lxb.demo.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lixiaobing
 * @date 2020-12-28 15:30
 * @Description:
 */
@Data
public class ProviderInfo {
    private String       id;
    private String       url;
    private List<String> tags;
    private Integer      weight;

    public ProviderInfo() {
    }

    public ProviderInfo(String id, String url, List<String> tags, Integer weight) {
        this.id     = id;
        this.url    = url;
        this.tags   = tags;
        this.weight = weight;
    }
}
