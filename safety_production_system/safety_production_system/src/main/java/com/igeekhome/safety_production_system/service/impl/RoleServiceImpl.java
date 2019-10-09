package com.igeekhome.safety_production_system.service.impl;

import com.igeekhome.safety_production_system.mapper.RoleMapper;
import com.igeekhome.safety_production_system.pojo.SysRole;
import com.igeekhome.safety_production_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Set<String> roleNameList(Integer uid) {
        List<SysRole> roles = roleMapper.selectRolesByUid(uid);
        Set<String> roleNames = new HashSet<>();
        for (SysRole role : roles){
            roleNames.add(role.getName());
        }
        return roleNames;
    }
}
