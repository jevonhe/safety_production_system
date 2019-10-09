package com.igeekhome.safety_production_system.mapper;

import com.igeekhome.safety_production_system.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

@Mapper
public interface RoleMapper {

    //@Select("select r.* from role r,user_role ur where ur.roleid = r.roleid and ur.userid = #{userid}")
    @Select("select * from sys_role where id in (select rid from sys_role_user where uid = #{userid})")
    List<SysRole> selectRolesByUid(Integer uid);
}
