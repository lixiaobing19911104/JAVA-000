package com.lxb.tcc.mappers;

import com.lxb.tcc.entity.TransactionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lixiaobing
 * @date 2020-12-25 14:57
 * @Description:
 */
@Repository
public interface TransactionInfoMapper {
    /**
     * insert one
     *
     * @param transactionInfo entity
     */
    void insertOne(TransactionInfo transactionInfo);

    /**
     * update one
     *
     * @param transactionInfo entity
     */
    void updateOne(TransactionInfo transactionInfo);

    /**
     * query
     *
     * @param condition query condition
     * @return result list
     */
    List<Map<String, Object>> query(Map<String, Object> condition);

}
