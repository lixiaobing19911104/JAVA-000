package demo;

import com.alibaba.fastjson.parser.ParserConfig;
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

        ParserConfig.getGlobalInstance().addAccept("com.rpc.demo.model.Order");
        ParserConfig.getGlobalInstance().addAccept("com.rpc.demo.model.User");

        RpcClient client = new RpcByteBody();

        UserService userService = client.create(UserService.class);
        User user = userService.findById(1);
        if (user == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println("\n\nfind user id=1 from server: " + user.getName());

        OrderService orderService = client.create(OrderService.class);
        Order order = orderService.findById(1992129);
        if (order == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println("\n\n" + String.format("find order name=%s, user=%d",order.getName(),order.getUserId()));
    }

}
