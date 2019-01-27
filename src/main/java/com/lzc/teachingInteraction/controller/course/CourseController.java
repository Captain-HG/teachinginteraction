package com.lzc.teachingInteraction.controller.course;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.Material;
import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.MaterialService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 课程的控制层
 */
@Controller
public class CourseController {
    @Autowired
    CourseServcice courseServcice;
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;
    @Autowired
    MaterialService materialService;
    /**
     * 跳转到课程详情
     * @Param cId 课程id
     * @return
     */
    @RequestMapping("")
    public String courseDetail(Model model,String cId){
        System.out.println("cId:"+cId);
        Course course = courseServcice.selectById(cId);
        System.out.println("课程："+course);
        List<Material> materialList = materialService.selectAllByCId(cId);
        Teacher teacher = teacherService.selectById(course.gettId());
        User user = userService.selectById(teacher.getuId());

        model.addAttribute("course",course);
        model.addAttribute("user",user);
        model.addAttribute("materialList",materialList);
        return "course/course";
    }

    /**
     * 跳转到课程列表
     * @param model
     * @return
     */
    @RequestMapping("course-list.html")
     public String courseList(Model model){
        List<CourseVo> courseVos = courseServcice.selectAllVo();
        model.addAttribute("courseVos",courseVos);
        model.addAttribute("commons",new Commons());
        return "course/course-list";
    }
}
