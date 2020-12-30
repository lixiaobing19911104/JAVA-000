package com.lxb.demo.filter;

import com.lxb.demo.api.ProviderInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaobing
 * @date 2020-12-31 01:24
 * @Description:
 */
public class FilterLine {
    private static boolean         isInit     = false;
    private static List<RpcFilter> rpcFilters = new ArrayList<>();

    private static void init() {
        addFilter(new TagFilter());
    }

    public static void addFilter(RpcFilter filter) {
        rpcFilters.add(filter);
    }

    public static List<ProviderInfo> filter(List<ProviderInfo> providers, List<String> tags) {
        if (!isInit) {
            init();
            isInit = true;
        }

        List<ProviderInfo> filterResult = new ArrayList<>(providers);

        for (RpcFilter filter : rpcFilters) {
            filterResult = filter.filter(filterResult, tags);
        }

        System.out.printf("\n%s filter to %s\n", providers, filterResult);
        return filterResult;
    }

}
