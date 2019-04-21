package com.lzc.teachingInteraction.controller.student;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.mapper.RaQueueMapper;
import com.lzc.teachingInteraction.service.QueueService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
  @Autowired
  QueueService queueService;
  /**
   * 跳转到学生的用户中心
   * @return
   */
  @RequestMapping("student-center-index.html")
    public String studentCenterIndex(Model model){
    User user  = (User) SecurityUtils.getSubject().getPrincipal();
      if(user.getType()== WebConst.USER_TYPE_STUDENT&&user!=null){
    user.setPassword(null);
    int queueSize = queueService.selectAllByToUIdAndStateSize(user.getuId());
    model.addAttribute("queueSize",queueSize);
    model.addAttribute("user",user);
    return "student/center";
  }
      else {
    return "index/index";
  }
}


}
