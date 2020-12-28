package demo;

import com.lxb.demo.netty.server.RpcNettyServer;
import com.lxb.demo.proxy.ProviderServiceManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 不使用 spring boot web，启动 netty server 进行监听
 *
 * @author lw
 */
@SpringBootApplication
@Slf4j
public class ServerApplication implements ApplicationRunner {


    public ServerApplication() {

    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            final int port = 8080;
            ProviderServiceManagement.init("com.rpc.server.demo.service.impl", port);

            final RpcNettyServer rpcNettyServer = new RpcNettyServer(port);

            rpcNettyServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
