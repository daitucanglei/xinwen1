package com.service;

import com.pojo.User;

public interface UserService {
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}
