package com.leike.service;

import com.leike.pojo.User;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-25 19:09
 */
public interface UserService {

    /**
     * 根据user信息去检查数据库是否存在用户
     * @param user
     * @return
     */
    User get(User user);

    boolean delete(String name);
}
