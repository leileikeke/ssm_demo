package com.leike.service.impl;

import com.leike.mapper.UserMapper;
import com.leike.pojo.User;
import com.leike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-25 19:12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    //注入mapper
    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(User user) {
        //提前检查
        if (user == null){
            return null;
        }
        User u = userMapper.query(user);
        System.out.println(u);
        return u;
    }

    @Override
    public boolean delete(String name) {
        int row = userMapper.delete(name);

        return row==1?true:false;

    }
}
