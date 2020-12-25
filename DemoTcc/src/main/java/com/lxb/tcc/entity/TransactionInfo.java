package com.lxb.tcc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lixiaobing
 * @date 2020-12-25 14:54
 * @Description:
 */
@Data
@Entity
@Table(name = "transaction_info")
@NoArgsConstructor
public class TransactionInfo implements Serializable {
    @Id
    @GeneratedValue
    Long id;
    String xid;
    int    status;
    String className;
    String commitMethodName;
    String cancelMethodName;
}
