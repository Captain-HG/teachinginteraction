package com.lzc.teachingInteraction.shiro;


import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.AdminService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * 自定义规则类
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    TeacherService teacherService;
    /**
     *执行授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("shouquan");
        //进行授权，SimpleAuthorizationInfo为AuthorizationInfo的子类
      SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        //判断管理员身份
        if(user.getType()==2&&adminService.isExtis(user.getuId()))
        {
            System.out.println("admin");
            info.addRole("admin");
        }

        if(user.getType()== WebConst.USER_TYPE_TEACHER &&teacherService.isExtis(user.getuId()))
        {
            System.out.println("老师");
            info.addRole("teacher");
        }
        return info;
    }

    /**
     *执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        System.out.println("renzheng");
       /**1、写死的情况下
        * System.out.println("renzheng ");
        String name = "123";
        String password="123";
       UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
       if (token.getUsername().equals(name)) {
           //用户不存在
           return null;//默认会抛出UnknowAccountException
       }
       //2.判断密码
        return new SimpleAuthenticationInfo("",password,getName());
    }
        */

       //2、加上数据库验证的情况
        String  account = authenticationToken.getPrincipal().toString();
       User user = userService.selectByAccount(account);
          if (user==null){
              return null;
          }
          //将user传递到授权任务中
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
