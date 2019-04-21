package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.entity.Course;
import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.CourseServcice;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.utils.FileUtils;
import com.lzc.teachingInteraction.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程方面的管理
 */
@Controller
public class AdminCourseController {
     @Autowired
    CourseServcice courseServcice;
     @Autowired
    TeacherService teacherService;
     @Autowired
    UserService userService;
    /**
     * 课程列表
     * @param model
     * @return
     */
    @RequestMapping("admin-course-list.html")
    public String courseList(Model model){
        List<CourseVo> courseVos = courseServcice.selectAllVo();
        model.addAttribute("courseVos",courseVos);
        model.addAttribute("commons",new Commons());
        return "admin/course/list";
    }

    /**
     * 课程修改页面跳转
     * @param model
     * @param cId
     * @return
     */
    @RequestMapping("admin-course-update.html")
    public String courseUpdateUi(Model model,String cId){
        Course course = courseServcice.selectById(cId);
        Teacher teacher = teacherService.selectById(course.gettId());
        User user = userService.selectById(teacher.getuId());
        model.addAttribute("course",course);
        model.addAttribute("tName",user.getuName());
        model.addAttribute("tId",teacher.gettId());
        model.addAttribute("commons",new Commons());
        return  "admin/course/update";
    }

    /**
     * 更新的实现
     * @param course
     * @param req
     * @param multiReq
     * @return
     */
    @RequestMapping("admin-course-update")
    @ResponseBody
    public String courseUpdate(Course course, HttpServletRequest req,
                               MultipartHttpServletRequest multiReq){
        String logUrl = FileUtils.UploadFile(req, multiReq);
        System.out.println(logUrl);
        course.setcLogourl(logUrl);
        courseServcice.update(course);
        return "success";
    }

    /**
     * 删除
     * @param cId
     * @return
     */
    @RequestMapping("admin-course-del")
    @ResponseBody
    public String courseDel(String cId){
        courseServcice.del(cId);
        return "success";
    }
    /**
     * 启用课程
     * @param cId
     * @return
     */
    @RequestMapping("admin-start-course")
    @ResponseBody
    public String courseStart(String cId){
       courseServcice.start(cId);
        return "success";
    }

    /**
     * jin用课程
     * @param cId
     * @return
     */
    @RequestMapping("admin-stop-course")
    @ResponseBody
    public String courseStop(String cId){
       courseServcice.stop(cId);
        return "success";
    }
}
