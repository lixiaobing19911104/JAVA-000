package com.lxb.rw.context;

import com.lxb.rw.cons.DataSourceType;

/**
 * @author lixiaobing
 * @date 2020-12-03 01:17
 * @Description:
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceType> local = new ThreadLocal<>();

    public static void read() {
        System.out.println("reader data source");
        local.set(DataSourceType.READ);
    }

    public static void write() {
        System.out.println("write data source");
        local.set(DataSourceType.WRITE);
    }

    public static DataSourceType getJdbcType() {
        return local.get();
    }

}
