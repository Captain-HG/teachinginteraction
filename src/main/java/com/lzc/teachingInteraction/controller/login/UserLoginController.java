package com.lzc.teachingInteraction.controller.login;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 对于登录功能的实现
 */
@Controller
public class UserLoginController {
    @Autowired
    UserService userService;
    /**
     * 跳转到用户登录
     * @return
     */
    @RequestMapping("userLogin.html")
    public String userLogin(){
        return "login/userLogin";
    }

//    /**
//     * 登录实现
//     * @return
//     */
//    @RequestMapping("loginSure")
//    @ResponseBody
//    public String loginSure(String account,String password){
//        System.out.println("账号："+account+"，密码："+password);
//
//        if (StringUtils.isNotBlank(account)&&StringUtils.isNotBlank(password)){
//            return userService.loginSure(account, password);
//        }
//        else {
//           return  "账号密码不能为空";
//        }
//
//    }
        /**
     * 登录实现
     * @return
     */
    @RequestMapping("loginSure")
    @ResponseBody
    public String loginUp(String account, String password, Model model, HttpSession session){
        if (StringUtils.isNotBlank(account)&&StringUtils.isNotBlank(password)) {
            System.out.println("账号：" + account + "，密码：" + password);

            /**
             * 使用shiro编写认证
             */
            //1.获取subject
            Subject subject = SecurityUtils.getSubject();
            //2、封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            //3、执行登录
            try {
                subject.login(token);
                User user=(User) subject.getPrincipal();
                System.out.println("user:"+user);
//                session.setAttribute(WebConst.USER_SESSION,user);
                //登录成功
                return "success";
            } catch (UnknownAccountException e) {
                //异常，账号不存在
                model.addAttribute("msg", "账号不存在");
                return "账号不存在";
            } catch (IncorrectCredentialsException e) {
                //登陆失败；密码错误
                model.addAttribute("msg", "密码错误");
                return "密码错误";
            }
        }
        else {
           return "账号或密码不能为空！！";
        }

    }
    /**
     * 登出的实现
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        System.out.println("登出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        return "/";
    }

}
