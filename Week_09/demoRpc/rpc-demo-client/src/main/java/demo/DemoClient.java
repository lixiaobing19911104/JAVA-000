package demo;

import com.lxb.demo.proxy.RpcByteBody;
import com.lxb.demo.proxy.RpcClient;
import com.lxb.demo.proxy.RpcClientJdk;
import demo.service.OrderService;
import demo.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lixiaobing
 * @date 2020-12-27 23:42
 * @Description:
 */
@Slf4j
public class DemoClient {
    public static void main(String[] args) {

        RpcClient   jdk         = new RpcClientJdk();
        UserService userService = jdk.create(UserService.class, "http://localhost:8080/");
        User        user        = userService.findById(1);
        if (user == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println("find user id=1 from server: " + user.getName());

        RpcClient    buddy        = new RpcByteBody();
        OrderService orderService = buddy.create(OrderService.class, "http://localhost:8080/");
        Order        order        = orderService.findById(1992129);
        if (order == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println(String.format("find order name=%s, user=%d",order.getName(),order.getUserId()));

        order = orderService.findError();
        if (order == null) {
            log.info("Clint service invoke Error");
        }
    }

}
