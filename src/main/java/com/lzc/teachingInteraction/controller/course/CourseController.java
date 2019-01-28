package com.lzc.teachingInteraction.controller.course;

import com.lzc.teachingInteraction.entity.*;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.utils.FileUtils;
import com.lzc.teachingInteraction.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    SubjectService subjectService;
    /**
     * 跳转到课程详情
     * @Param cId 课程id
     * @return
     */
    @RequestMapping("course-detail")
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
        return "course/course-detail";
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

    /**
     * 跳转到课程的视频页
     * @param id 资料id
     * @param model
     * @return
     */
    @RequestMapping("course-video.html")
    public  String  courseVideo(String id,Model model){
        Material material = materialService.selectById(id);
        model.addAttribute("material",material);
        return "course/course-video";
    }

    /**
     * 课程视频、文件下载
     * @param request
     * @param response
     * @param mId 课程id
     * @return
     */
    @RequestMapping("course-down")
    @ResponseBody
    public String courseDown(HttpServletRequest request, HttpServletResponse response,String mId){
        String fileName = materialService.selectById(mId).getUrl();
        return FileUtils.downloadFile(request,response,fileName);
    }

    /**
     * 答题网页
     * @param model
     * @param eId
     * @return
     */
    @RequestMapping("course-answer.html")
    public String courseAnswer(Model model,String eId){
        List<Subject> subjectList = subjectService.selectALLByEId(eId);
        model.addAttribute("subjectList",subjectList);
        return "course/course-answer";
    }
}
