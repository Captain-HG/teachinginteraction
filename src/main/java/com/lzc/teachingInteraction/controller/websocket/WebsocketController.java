package com.lzc.teachingInteraction.controller.websocket;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 聊天功能的控制层
 */
@Controller
public class WebsocketController {
    @Autowired
    UserService userService;
    /**
     * 页面的跳转
     * @param uId 发起聊天的用户id
     * @param model 传递
     * @return
     */
    @RequestMapping("/websocket/{uId}")
    public String websocket(@PathVariable String uId, Model model){
        User user = userService.selectById(uId);
        System.out.println(user.getuName());
        model.addAttribute("userName",user.getuName());
        return "websocketTest";
    }
    @RequestMapping("/test05/{uId}")
    public String testWebsocket(@PathVariable String uId,Model model){
        User user = userService.selectById(uId);
        model.addAttribute("user",user);
        return "test05";
    }
}
