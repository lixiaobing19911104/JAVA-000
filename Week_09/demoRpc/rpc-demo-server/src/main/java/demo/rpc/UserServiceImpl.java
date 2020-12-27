package demo.rpc;


import demo.User;
import demo.service.UserService;

/**
 * @author lw
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC");
    }
}
