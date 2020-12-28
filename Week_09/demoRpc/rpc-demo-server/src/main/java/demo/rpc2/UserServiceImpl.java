package demo.rpc2;


import com.lxb.demo.annotation.RpcService;
import demo.User;
import demo.service.UserService;

/**
 * @author lw
 */
@RpcService(service = "demo.service.UserService", group = "g1", version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC");
    }
}
