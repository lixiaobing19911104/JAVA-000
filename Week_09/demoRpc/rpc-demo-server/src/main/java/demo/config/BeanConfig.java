package demo.config;

import demo.rpc.OrderServiceImpl;
import demo.rpc.UserServiceImpl;
import demo.service.OrderService;
import demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置接口的实现类
 *
 * @author lw
 */
@Configuration
public class BeanConfig {

    @Bean("demo.service.UserService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean("demo.service.OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
}
