package demo.rpc2;


import com.lxb.demo.annotation.RpcService;
import demo.User;
import demo.service.UserService;

/**
 * @author lw
 */
@RpcService(service = "com.rpc.demo.service.UserService", group = "group2", version = "v2")
public class UserServiceV2Impl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC group2 v2");
    }
}
