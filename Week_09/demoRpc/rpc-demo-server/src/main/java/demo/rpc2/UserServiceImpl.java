package demo.rpc2;

import com.lxb.demo.annotation.RpcService;
import demo.User;
import demo.service.UserService;

/**
 * @author lw
 */
@RpcService(service = "com.rpc.demo.service.UserService", weight = 8)
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC weight8");
    }
}
