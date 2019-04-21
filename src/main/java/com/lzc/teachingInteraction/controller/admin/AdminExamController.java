package com.lzc.teachingInteraction.controller.admin;



import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.Exam;
import com.lzc.teachingInteraction.entity.Material;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.Commons;

import com.lzc.teachingInteraction.vo.ExamVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * 考试 方面的管理
 */
@Controller
public class AdminExamController {
     @Autowired
     ExamService examService;
     @Autowired
     CourseServcice courseServcice;
     @Autowired
     MaterialService materialService;
    /**
     * 课程列表
     * @param model
     * @return
     */
    @RequestMapping("admin-exam-list.html")
    public String examList(Model model){
        List<ExamVo> examVos = examService.selectAllVo();
        model.addAttribute("examVos",examVos);
        model.addAttribute("commons",new Commons());
        return "admin/exam/list";
    }

    /**
     * 资料修改页面跳转
     * @param model
     * @return
     */
    @RequestMapping("admin-exam-update.html")
    public String examUpdateUi(Model model,String eId){
        System.out.println("mid:"+eId);
        Exam exam = examService.selectById(eId);
        model.addAttribute("exam",exam);
        List<Course> courseList = courseServcice.selectAll();
        model.addAttribute("courseList",courseList);
        if (StringUtils.isNotBlank((exam.getmId()))) {
            model.addAttribute("material", materialService.selectById(exam.getmId()));
        }else {
            model.addAttribute("material",null);
        }

        return  "admin/exam/update";
    }

    /**
     * 更新的实现
     * @param exam
     * @return
     */
    @RequestMapping("admin-exam-update")
    @ResponseBody
    public String examUpdate(Exam exam){
        System.out.println("更新："+exam);
        examService.update(exam);
        return "success";
    }

    /**
     * 删除
     * @param eId
     * @return
     */
    @RequestMapping("admin-exam-del")
    @ResponseBody
    public String examDel(String eId){
        examService.del(eId);
        return "success";
    }

    /**
     * 跳转到增加资料的页面
     * @param model
     * @return
     */
   @RequestMapping("admin-exam-add.html")
    public String examAddUi(Model model){
       List<Course> courseList = courseServcice.selectAll();
       model.addAttribute("courseList",courseList);
        return "admin/exam/add";
   }

    /**
     * 添加的实现
     * @param exam
     * @return
     */
   @RequestMapping("admin-exam-add")
   @ResponseBody
    public String examAdd(Exam exam){
       System.out.println(exam);
       examService.add(exam);
       return "success";
   }

    /**
     * ajax的联动
     * @param cId
     * @return
     */
   @RequestMapping("admin-exam-materialList")
   @ResponseBody
    public List<Material> examMaterialList(String cId){
       System.out.println("ajax:"+cId);
       List<Material> materialList = materialService.selectAllByCId(cId);
       System.out.println("集合list:"+materialList);
       return materialList;
   }
}
