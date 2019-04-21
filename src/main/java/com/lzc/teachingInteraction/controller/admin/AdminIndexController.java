package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.QueueService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndexController {
    @Autowired
    QueueService queueService;
    /**
     * 首页跳转
     * @return
     */
   @RequestMapping("admin-index")
    public String adminIndex(Model model){
       User user  = (User) SecurityUtils.getSubject().getPrincipal();
       if(user.getType()== WebConst.USER_TYPE_ADNIN&&user!=null){
           user.setPassword(null);
           int queueSize = queueService.selectAllByToUIdAndStateSize(user.getuId());
           model.addAttribute("queueSize",queueSize);
           model.addAttribute("user",user);
           return "admin/index";
       }
       else {
           return "index/index";
       }

   }

}
