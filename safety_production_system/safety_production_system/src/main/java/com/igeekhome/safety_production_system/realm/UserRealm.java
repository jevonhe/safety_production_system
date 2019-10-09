package com.igeekhome.safety_production_system.realm;

import com.igeekhome.safety_production_system.pojo.SysUser;
import com.igeekhome.safety_production_system.service.PermissonService;
import com.igeekhome.safety_production_system.service.RoleService;
import com.igeekhome.safety_production_system.service.UserService;
import com.igeekhome.safety_production_system.util.ShiroUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissonService permissonService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户省份
        String username = (String)authenticationToken.getPrincipal();
        //根据用户身份获取用户对象
        SysUser user = userService.queryUserByUsername(username);

        //根据用户的id获取用户的角色以及权限
        Set<String> roleNames = roleService.roleNameList(user.getId());
        Set<String> permissionNames = permissonService.permissonNameList(user.getId());

        ShiroUser shiroUser = new ShiroUser(user,roleNames,permissionNames);

        ByteSource credentialSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser,user.getPwd(),credentialSalt,getName());

        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        //设置角色权限
        if(shiroUser.getPermissons()!=null&&shiroUser.getPermissons().size()>0){
            info.setStringPermissions(shiroUser.getPermissons());
        }

        if(shiroUser.getRoles()!=null&&shiroUser.getRoles().size()>0){
            info.setRoles(shiroUser.getRoles());
        }
        return info;
    }


}
