/**
 * 文 件 名:  MyAbstractRoutingDataSource
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2019/3/1 0001
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.lxb.rw.config;

import com.lxb.rw.cons.DataSourceType;
import com.lxb.rw.context.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <多数据源切换>
 *
 * @author zping
 * @version 2019/3/1 0001
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 数据源
     */
    private final int dataSourceNumber;

    public MyAbstractRoutingDataSource(int dataSourceNumber) {
        this.dataSourceNumber = dataSourceNumber;
    }

    @Override
    protected Object determineCurrentLookupKey() {

        DataSourceType jdbcType = DataSourceContextHolder.getJdbcType();
        if (jdbcType.equals(DataSourceType.WRITE)) {
            return DataSourceType.WRITE;
        } else {
            return DataSourceType.READ;
        }
    }

}
