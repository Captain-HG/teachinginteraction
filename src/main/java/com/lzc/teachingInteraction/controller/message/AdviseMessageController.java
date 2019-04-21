package com.lzc.teachingInteraction.controller.message;

import com.lzc.teachingInteraction.entity.Advise;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.AdviseService;
import javafx.scene.Parent;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *对于首页建议的实现
 */
@Controller
public class AdviseMessageController {
    @Autowired
    AdviseService adviseService;
    /**
     * 保存意见
     * @param model
     * @param request
     * @param advise
     * @return
     */
    @RequestMapping("send-advise")
    @ResponseBody
    public String acceptAdvise(Model model, HttpServletRequest request, Advise advise){
        System.out.println("建议"+advise);
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println("shiro的："+user);
        advise.setUserId(user.getuId());
      int i = adviseService.add(advise);
        return "success";
    }

}
