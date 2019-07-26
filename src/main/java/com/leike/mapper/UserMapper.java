package com.leike.mapper;

import com.leike.pojo.User;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-25 18:40
 */

public interface UserMapper {

    User query(User user);

    int delete(String name);
}
