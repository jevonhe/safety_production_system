package com.igeekhome.safety_production_system.util;

import com.igeekhome.safety_production_system.pojo.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiroUser {

    private SysUser user;
    private Set<String> roles;
    private Set<String> permissons;
}
