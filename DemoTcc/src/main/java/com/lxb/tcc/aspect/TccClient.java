package com.lxb.tcc.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaobing
 * @date 2020-12-25 15:38
 * @Description:
 */
@RestController
@RequestMapping("/tm")
public class TccClient {
    private TccTransactionManager tccTransactionManager;

    public TccClient(TccTransactionManager tccTransactionManager) {
        this.tccTransactionManager = tccTransactionManager;
    }
    @GetMapping("/tryNext")
    public boolean tryNextStep(@RequestParam(value = "xid") String xid) {
        return tccTransactionManager.transactionHandle(xid);
    }

}
