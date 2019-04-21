package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.entity.Subject;
import com.lzc.teachingInteraction.service.SubjectService;
import com.lzc.teachingInteraction.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminSubjectController {
    @Autowired
    SubjectService subjectService;

    /**
     * 通过考试id查询它的
     * @param eId 考试id
     * @return
     */
    @RequestMapping("admin-subject-list.html")
    public String subjectList(String eId, Model model){
        List<Subject> subjects = subjectService.selectALLByEId(eId);
        model.addAttribute("subjects",subjects);
        model.addAttribute("eId",eId);
        model.addAttribute("commons",new Commons());
        return "admin/subject/list";
    }

    /**
     * 跳转到增加页面
     * @param model
     * @param eId
     * @return
     */
    @RequestMapping("admin-subject-add.html")
    public String subjectAddUi(Model model,String eId ){
         model.addAttribute("eId",eId);
        return "admin/subject/add";
    }

    /**
     * 一个题目的增加
     * @param subject
     * @return
     */
    @RequestMapping("admin-subject-add")
    @ResponseBody
    public String subjectAdd(Subject subject){
        System.out.println("题目的增加"+subject);
        subjectService.add(subject);
        return "success";
    }

    /**
     * 编辑页面跳转
     * @param sId
     * @param model
     * @return
     */
    @RequestMapping("admin-subject-update.html")
    public String subjectUpdateUi(String sId,Model model){
        System.out.println("题库更新："+sId);
         model.addAttribute("subject",subjectService.selectById(sId));
        return "admin/subject/update";
    }

    /**
     * 跟新的实现
     * @param subject
     * @return
     */
    @RequestMapping("admin-subject-update")
    @ResponseBody
    public String subjectUpdate(Subject subject){
        System.out.println("跟新："+subject);
        subjectService.update(subject);
        return "success";
    }

    /**
     * 删除该题目
     * @param sId 题目id
     * @return
     */
    @RequestMapping("admin-subject-del")
    @ResponseBody
    public String subjectDel(String sId){
        System.out.println("删除"+sId);
        subjectService.del(sId);
        return "success";
    }
}
