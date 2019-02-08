package com.lzc.teachingInteraction.controller.teacher;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;

    /**
     * 跳转到老师列表
     * @param model
     * @return
     */
    @RequestMapping("teacher-list.html")
    public String teacherList(Model model){
        List<User> userList = userService.selectByTeacher();
        model.addAttribute("userList",userList);
        model.addAttribute("commons",new Commons());
        return "teacher/teacher-list";
    }

}
