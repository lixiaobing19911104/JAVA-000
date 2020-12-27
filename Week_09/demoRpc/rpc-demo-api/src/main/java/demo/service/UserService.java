package demo.service;


import demo.User;

/**
 * @author lw
 */
public interface UserService {

    /**
     * find by id
     * @param id id
     * @return user
     */
    User findById(Integer id);
}
