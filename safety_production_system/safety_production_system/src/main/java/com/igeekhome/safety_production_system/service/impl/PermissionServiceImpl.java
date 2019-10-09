package com.igeekhome.safety_production_system.service.impl;

import com.igeekhome.safety_production_system.mapper.PermissionMapper;
import com.igeekhome.safety_production_system.pojo.SysPermission;
import com.igeekhome.safety_production_system.service.PermissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissonService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public Set<String> permissonNameList(Integer uid) {
        List<SysPermission> permissions = permissionMapper.selectPermissionsByUid(uid);

        Set<String> permissonNames = new HashSet<>();

        for(SysPermission permission : permissions){
            permissonNames.add(permission.getPercode());
        }

        return permissonNames;
    }
}
