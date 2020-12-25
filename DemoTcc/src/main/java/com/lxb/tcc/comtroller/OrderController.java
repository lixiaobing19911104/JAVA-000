package com.lxb.tcc.comtroller;

import com.lxb.tcc.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaobing
 * @date 2020-12-25 15:40
 * @Description:
 */
@RestController
@RequestMapping("/transaction")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/commit")
    public String commit() {
        try {
            orderService.buySuccess();
            return "commit success";
        } catch (RuntimeException e) {
            return "commit failed";
        }
    }

    @GetMapping(value = "/cancel")
    public String cancel() {
        try {
            orderService.buyFailed();
            return "commit success";
        } catch (RuntimeException e) {
            return "commit failed";
        }
    }
}
