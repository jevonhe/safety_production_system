package com.igeekhome.safety_production_system.mapper;

import com.igeekhome.safety_production_system.pojo.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user where loginname = #{username}")
    List<SysUser> selectUserByName(String username);
}
