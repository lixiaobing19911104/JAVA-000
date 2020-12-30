package com.lxb.demo.lb;

import com.lxb.demo.api.ProviderInfo;

import java.util.List;

/**
 * @author lixiaobing
 * @date 2020-12-31 01:04
 * @Description:
 */
public interface LoadBalance {
    String select(List<ProviderInfo> providers, String serviceName, String methodName);
}
