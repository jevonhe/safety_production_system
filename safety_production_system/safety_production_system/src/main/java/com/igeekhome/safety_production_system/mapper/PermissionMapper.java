package com.igeekhome.safety_production_system.mapper;

import com.igeekhome.safety_production_system.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

@Mapper
public interface PermissionMapper {

    @Select("select * from sys_permission where id in (select rp.pid from sys_role_user ur,sys_role_permission rp where ur.rid = rp.rid and ur.uid = #{userid})")
    List<SysPermission> selectPermissionsByUid(Integer uid);
}
