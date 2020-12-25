package com.lxb.tcc.service.impl;

import com.lxb.tcc.annotation.TccAction;
import com.lxb.tcc.aspect.RootContext;
import com.lxb.tcc.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lw
 */
@Component
@Slf4j
public class StoreAccountServiceImpl implements Service {

    @Override
    @TccAction(name = "prepare", confirmMethod = "commit", cancelMethod = "cancel")
    public boolean prepare(boolean success) {
        log.info("store prepare");
        log.info("global transaction id:: " + RootContext.get());
        if (success) {
            log.info("Store prepare success");
        } else {
            log.info("Store prepare failed");
        }
        return success;
    }

    @Override
    public boolean commit() {
        log.info("Store commit");
        log.info("global transaction id:: " + RootContext.get());
        return true;
    }

    @Override
    public boolean cancel() {
        log.info("Store cancel");
        log.info("global transaction id:: " + RootContext.get());
        return true;
    }
}
