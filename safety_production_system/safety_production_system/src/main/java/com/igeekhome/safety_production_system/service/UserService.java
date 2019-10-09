package com.igeekhome.safety_production_system.service;

import com.igeekhome.safety_production_system.pojo.SysUser;

public interface UserService {

    SysUser queryUserByUsername(String username);
}
