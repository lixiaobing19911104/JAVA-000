package demo.rpc;

import com.lxb.demo.annotation.RpcService;
import demo.User;
import demo.service.UserService;

/**
 * @author lw
 */
@RpcService(service = "demo.service.UserService", group = "group2", version = "v2", tags = "tag2")
public class UserServiceV2Impl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC group2 v2");
    }
}
