package demo.rpc;

import com.lxb.demo.annotation.RpcService;
import demo.User;
import demo.service.UserService;

/**
 * @author lw
 */
@RpcService(service = "demo.service.UserService", weight = 2)
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC weight 2");
    }
}
