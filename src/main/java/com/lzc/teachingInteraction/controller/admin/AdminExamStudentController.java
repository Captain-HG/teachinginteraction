package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.service.UserExamService;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.vo.UserExamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminExamStudentController {
    @Autowired
    UserExamService userExamService;

    /**
     * 考试记录list
     * @param model
     * @param eId
     * @return
     */
    @RequestMapping("admin-userExam-list.html")
    public String userExamList(Model model,String eId){
        List<UserExamVo> userExamVos = userExamService.selectAllByEId(eId);
        model.addAttribute("userExamVos",userExamVos);
        model.addAttribute("commons",new Commons());
        return "admin/exam/userList";
    }

}
