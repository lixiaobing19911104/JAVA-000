package com.lxb.demo.service;


import com.lxb.demo.model.User;

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
