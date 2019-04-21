package com.lzc.teachingInteraction.controller.login;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRegisterController {
    @Autowired
    UserService userService;

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("userRegister.html")
    public String registerUi(){
        return "login/userRegister";
    }

    /**
     *注册的实现，头像使用默认
     * @param user
     * @param schoolName
     * @param grade
     * @return
     */
    @RequestMapping("userRegister")
    @ResponseBody
    public String register(User user,String schoolName,String grade){
        System.out.println("注册中的user:"+user);
        System.out.println("学校："+schoolName+"年级："+grade);
        if (user.getType()==0){
           user.setHeadimg("img/people/girl.jpg");
        }else {
            user.setHeadimg("img/people/boy.jpg");
        }
        userService.add(user,schoolName,grade);
        return "success";
    }

}
