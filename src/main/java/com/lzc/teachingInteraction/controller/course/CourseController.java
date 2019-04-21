package com.lzc.teachingInteraction.controller.course;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.*;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.utils.FileUtils;
import com.lzc.teachingInteraction.vo.CourseVo;
import com.lzc.teachingInteraction.vo.EvaluateCourseVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    ExamService examService;
    @Autowired
    EvaluateService evaluateService;
    @Autowired
    CourseUserService courseUserService;
    /**
     * 跳转到课程详情
     * @Param cId 课程id
     * @return
     */
    @RequestMapping("course-detail")
    public String courseDetail(Model model,String cId){
        System.out.println("cId:"+cId);
        Course course = courseServcice.selectById(cId);
        if (course==null||course.getState()!=1){//当状态不为1，或者课程为空，直接进入课程列表
            return "course/course-list";
        }
        else {
            System.out.println("课程：" + course);
            List<Material> materialList = materialService.selectAllByCId(cId);
            Teacher teacher = teacherService.selectById(course.gettId());
            User user = userService.selectById(teacher.getuId());//老师
            User user2 = (User) SecurityUtils.getSubject().getPrincipal();//登录用户
            String exist = courseUserService.isExit(course.getcId(), user2.getuId());
            System.out.println(exist);
            model.addAttribute("exist",exist);
            model.addAttribute("course", course);
            model.addAttribute("user", user);
            model.addAttribute("materialList", materialList);
            model.addAttribute("tId",teacher.gettId());
            return "course/course-detail";
        }
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
        Course course = courseServcice.selectById(material.getcId());
        List<Material> materials = materialService.selectAllByCId(course.getcId());
        System.out.println("资料："+material);
        model.addAttribute("material",material);
        model.addAttribute("materials",materials);
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
        materialService.downNumUpdate(mId);
        return FileUtils.downloadFile(request,response,fileName);
    }

    /**
     * 答题网页
     * @param model
     * @param cId
     * @Param mId
     * @return
     */
    @RequestMapping("course-answer.html")
    public String courseAnswer(Model model,String cId,String mId,String examId){
        //判断是不是期末考试,没有资料id就是期末考试，有就是单纯得测试
        System.out.println("mid:"+mId+",cid:"+cId);
        Exam exam = new Exam();
        if(StringUtils.isNotBlank(examId)){
             exam = examService.selectById(examId);
        }else{
         if (mId!=null){
           exam = examService.selectByMId(mId);
         }
         else{
           exam = examService.selectByCIdAndType(cId, WebConst.EXAM_TYPE_LAST);
         }
        }
        System.out.println("exam:"+exam);
        List<Subject> subjectList = subjectService.selectALLByEId(exam.getExamId());
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("eId",exam.getExamId());
        return "course/course-answer";
    }

    /**
     * 验证答题正确多少
     * @param eId 考试id
     * @param list 回答的答案list
     * @return
     */
    @RequestMapping("course-answer")
    @ResponseBody
    public List<Integer>  answerSure(@RequestBody List<Integer> list, String eId, Model model){
        System.out.println("回答集合："+list);
        System.out.println("eId:"+eId);
        List<Integer> scoreList = examService.scoreEqual(list, eId);//最后得分

        return scoreList;
    }

    /**
     * 跳转到评价页面,对某个课程的评价
     * @return
     */
    @RequestMapping("course-evaluate.html")
    public String evaluateCourse(Model model,String cId){

        System.out.println("cId:"+cId);
        List<EvaluateCourseVo> evaluateCourseVos = evaluateService.selectECVoByCId(cId);
        Course course = courseServcice.selectById(cId);
        System.out.println("课程："+course);

        Teacher teacher = teacherService.selectById(course.gettId());
        //此user为老师
        User user = userService.selectById(teacher.getuId());
        User user2 = (User) SecurityUtils.getSubject().getPrincipal();//登录用户
        String exist = courseUserService.isExit(course.getcId(), user2.getuId());

        model.addAttribute("course",course);
        user.setPassword(null);
        model.addAttribute("user",user);
        model.addAttribute("evaluateCourseVos",evaluateCourseVos);
        model.addAttribute("commons",new Commons());
        model.addAttribute("tId",teacher.gettId());
        model.addAttribute("exist",exist);
        return "course/course-evaluate";
    }

    @RequestMapping("course-user-list.html")
    public String courseUserList(String cId,Model model){
        System.out.println("课程id:"+cId);
        List<User> users = courseUserService.selectAllByCId(cId);
        model.addAttribute("userList",users);
        return "admin/course/user-list";
    }
}
