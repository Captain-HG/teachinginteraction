package com.lzc.teachingInteraction.controller.teacher;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.*;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.utils.FileUtils;
import com.lzc.teachingInteraction.vo.CourseVo;
import com.lzc.teachingInteraction.vo.EvaluateVo;
import com.lzc.teachingInteraction.vo.ExamVo;
import com.lzc.teachingInteraction.vo.MaterialVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;
    @Autowired
    CourseServcice courseServcice;
    @Autowired
    MaterialService materialService;
    @Autowired
    ExamService examService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    QueueService queueService;

    /**
     * 跳转到老师的用户中心
     *
     * @return
     */
    @RequestMapping("teacher-center-index.html")
    public String studentCenterIndex(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user.getType() == WebConst.USER_TYPE_TEACHER && user != null) {
            user.setPassword(null);
            int queueSize = queueService.selectAllByToUIdAndStateSize(user.getuId());
            model.addAttribute("queueSize",queueSize);
            model.addAttribute("user", user);
            return "teacher/center";
        } else {
            return "index/index";
        }
    }

    /**
     * 跳转到老师列表
     *
     * @param model
     * @return
     */
    @RequestMapping("teacher-list.html")
    public String teacherList(Model model) {
        List<User> userList = userService.selectByTeacher();
        model.addAttribute("userList", userList);
        model.addAttribute("commons", new Commons());
        return "teacher/teacher-list";
    }

    /**
     * 老师自己的课程列表
     */
    @RequestMapping("teacher-course-list.html")
    public String teacherCourseList(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            List<CourseVo> courseVos = courseServcice.selectAllVoByTId(teacherService.selectByUId(user.getuId()).gettId());
            model.addAttribute("courseVos", courseVos);
            model.addAttribute("commons", new Commons());
            return "teacher/course-list";
        }
    }

    @RequestMapping("teacher-course-add.html")
    public String teacherCourseAddUi(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            model.addAttribute("tId", teacherService.selectByUId(user.getuId()).gettId());
            model.addAttribute("commons", new Commons());
            return "teacher/course-add";
        }

    }

    @RequestMapping("teacher-course-add")
    @ResponseBody
    public String teacherCourseAdd(Course course, HttpServletRequest req,
                                   MultipartHttpServletRequest multiReq) {
        String logUrl = FileUtils.UploadFile(req, multiReq);
        if (StringUtils.isNotBlank(logUrl)) {
            course.setcLogourl(logUrl);
        }
        System.out.println("teacher:" + course);
        courseServcice.add(course);
        return "success";
    }

    @RequestMapping("teacher-course-update.html")
    public String teacherCourseUpdateUi(Model model, String cId) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            Course course = courseServcice.selectById(cId);
            Teacher teacher = teacherService.selectById(course.gettId());
            model.addAttribute("course", course);
            model.addAttribute("tName", user.getuName());
            model.addAttribute("tId", teacher.gettId());
            model.addAttribute("commons", new Commons());
            return "teacher/course-update";
        }

    }

    @RequestMapping("teacher-course-update")
    @ResponseBody
    public String teacherCourseUpdate(Course course, HttpServletRequest req,
                                      MultipartHttpServletRequest multiReq) {
        String logUrl = FileUtils.UploadFile(req, multiReq);
        if (StringUtils.isNotBlank(logUrl)) {
            course.setcLogourl(logUrl);
        }
        courseServcice.update(course);
        return "success";
    }

    /**
     * 资料列表
     *
     * @param model
     * @return
     */
    @RequestMapping("teacher-material-list.html")
    public String MaterialList(Model model, String cId) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "index/index";
        } else {
            System.out.println(cId);
            List<MaterialVo> MaterialVos = materialService.selectAllVoByCId(cId);
            model.addAttribute("MaterialVos", MaterialVos);
            model.addAttribute("commons", new Commons());
            model.addAttribute("cId", cId);
            return "teacher/material-list";
        }
    }

    /**
     * 资料修改页面跳转
     *
     * @param model
     * @param mId
     * @return
     */
    @RequestMapping("teacher-material-update.html")
    public String MaterialUpdateUi(Model model, String mId) {
        System.out.println("mid:" + mId);
        Material Material = materialService.selectById(mId);
        model.addAttribute("material", Material);
        model.addAttribute("commons", new Commons());
        return "teacher/material-update";
    }


    /**
     * 删除
     *
     * @param mId
     * @return
     */
    @RequestMapping("teacher-material-del")
    @ResponseBody
    public String MaterialDel(String mId) {
        materialService.del(mId);
        return "success";
    }

    /**
     * 跳转到增加资料的页面
     *
     * @param cId
     * @param model
     * @return
     */
    @RequestMapping("teacher-material-add.html")
    public String materialAddUi(String cId, Model model) {
        System.out.println("cid:" + cId);
        model.addAttribute("cId", cId);
        return "teacher/material-add";
    }

    /**
     * 测试列表
     *
     * @param model
     * @return
     */
    @RequestMapping("teacher-exam-list.html")
    public String examList(Model model) {

            User user = (User) SecurityUtils.getSubject().getPrincipal();
            if (user == null || user.getuId() == null) {
                return "重新登录";
            } else {
                List<ExamVo> examVos = examService.selectAllVoByTId(teacherService.selectByUId(user.getuId()).gettId());
                System.out.println("老师课程的考试："+examVos);
                model.addAttribute("examVos", examVos);
                model.addAttribute("commons", new Commons());
                return "teacher/exam-list";
            }
        }
    /**
     * 通过考试id查询它的
     * @param eId 考试id
     * @return
     */
    @RequestMapping("teacher-subject-list.html")
    public String subjectList(String eId, Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            List<Subject> subjects = subjectService.selectALLByEId(eId);
            model.addAttribute("subjects", subjects);
            model.addAttribute("eId", eId);
            model.addAttribute("commons", new Commons());
            return "teacher/subject-list";
        }
    }
    @RequestMapping("teacher-showCourse-list.html")
    public String teacherCourseList(String tId,Model model,String uId){
        if (StringUtils.isNotBlank(uId)){
            tId = teacherService.selectByUId(uId).gettId();
        }
            User user = userService.selectById(teacherService.selectById(tId).getuId());
            List<CourseVo> courseVos = courseServcice.selectAllVoByTId(tId);
            model.addAttribute("courseVos", courseVos);
            model.addAttribute("commons", new Commons());
            model.addAttribute("tName", user.getuName());
            user.setPassword(null);
            model.addAttribute("user", user);


        return "teacher/showCourse-list";
    }
}
