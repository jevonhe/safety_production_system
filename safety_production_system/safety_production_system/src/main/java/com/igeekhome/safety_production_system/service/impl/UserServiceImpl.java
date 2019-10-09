package com.igeekhome.safety_production_system.service.impl;

import com.igeekhome.safety_production_system.mapper.UserMapper;
import com.igeekhome.safety_production_system.pojo.SysUser;
import com.igeekhome.safety_production_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser queryUserByUsername(String username) {
        List<SysUser> users = userMapper.selectUserByName(username);
        if(users!=null&&users.size()>0){
            return users.get(0);
        }
        return null;
    }
}
