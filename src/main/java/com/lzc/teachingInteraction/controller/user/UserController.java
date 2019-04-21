package com.lzc.teachingInteraction.controller.user;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Advise;
import com.lzc.teachingInteraction.entity.RaQueue;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.rabbitmq.MyRabbitmq;
import com.lzc.teachingInteraction.service.*;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    CourseUserService courseUserService;
    @Autowired
    UserExamService userExamService;
    @Autowired
    UserService userService;
    @Autowired
    AdviseService adviseService;
    @Autowired
    EvaluateService evaluateService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    QueueService queueService;
    @Autowired
    MyRabbitmq myRabbitmq;
    /**
     * 用户个人中心的验证进入
     * @return
     */
    @RequestMapping("user-center-index.html")
    @ResponseBody
    public String userCenterIndex(){
        String s="";
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        if (user!=null&&user.getType()== WebConst.USER_TYPE_STUDENT){
            s="student-center-index.html";
        }else if(user!=null&&user.getType()== WebConst.USER_TYPE_TEACHER){
            s="teacher-center-index.html";
        }else if(user!=null&&user.getType()== WebConst.USER_TYPE_ADNIN){
            s="admin-index";
        }
      return s;
  }

    /**
     * 用户收藏课程
     * @param model
     * @return
     */
    @RequestMapping("user-course-list.html")
    public String userCourseList(Model model){
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        if (user==null&&user.getuId()!=null){
            return "login/userLogin";
        }
        else{
            List<CourseUserVo> courseUserVos = courseUserService.selectAllByUId(user.getuId());
            System.out.println("收藏课程list:"+courseUserVos);
            model.addAttribute("vos",courseUserVos);
            model.addAttribute("commons",new Commons());
            return "user/getCourseList";
        }

    }

    /**
     * 取消收藏
     * @param cId
     * @return
     */
    @RequestMapping("user-course-del")
    @ResponseBody
    public String userCourseDel(String cId){
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        if (user==null&&user.getuId()!=null){
            return "重新登录";
        }
        else{
           courseUserService.del(user.getuId(),cId);
            return "success";
        }
    }

    /**
     * 取用户考试的列表
     * @param model
     * @return
     */
    @RequestMapping("user-exam-list.html")
    public String userExamList(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            List<UserExamVo> userExamVos = userExamService.selectAllByUId(user.getuId());
            model.addAttribute("userExamVos",userExamVos);
            model.addAttribute("commons",new Commons());
            return "user/exam-list";
        }
    }

    /**
     * 跳转到修改密码的页面
     * @return
     */
    @RequestMapping("user-change-password.html")
    public String userPasswordChange(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            user.setPassword(null);
           model.addAttribute("user",user);
            model.addAttribute("commons", new Commons());
            return "user/change-password";
        }
    }
    /**
     * 修改密码的实现
     */
    @RequestMapping("user-change-password")
    public String userChangePassword(String uId,String password,String oldPassword){
         if (StringUtils.isNotBlank(oldPassword)&&userService.selectById(uId).equals(oldPassword)&&StringUtils.isNotBlank(password)&&StringUtils.isNotBlank(uId)){
             User user = userService.selectById(uId);
             user.setPassword(password);
             userService.update(user,null,null);
              return "success";
         }else {
             return "error";
         }
    }

    /**
     * 登录用户所提交的建议列表
     * @param model
     * @return
     */
    @RequestMapping("user-advise-list.html")
    public String userAdviseList(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            List<AdviseVo> adviseVos = adviseService.selectAllVoByUId(user.getuId());
            model.addAttribute("adviseVos",adviseVos);
            model.addAttribute("commons", new Commons());
            return "user/advise-list";
        }
    }

    /**
     * 删除
     * @param aId
     * @return
     */
    @RequestMapping("user-advise-del")
    @ResponseBody
    public String adviseDel(String aId){
        adviseService.del(aId);
        return "success";
    }

    /**
     * 建议编辑跳转
     * @param model
     * @param aId
     * @return
     */
    @RequestMapping("user-advise-edit.html")
    public String userAdviseEditUI(Model model,String aId){
        model.addAttribute("advise",adviseService.selectById(aId));
        return "user/advise-update";
    }

    /**
     * 修改实现
     * @param advise
     * @return
     */
    @RequestMapping("user-advise-update")
    @ResponseBody
    public String userAdviseEdit(Advise advise){
        adviseService.update(advise);
        return "success";
    }
    @RequestMapping("user-evaluate-list.html")
    public String userEvaluateList(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "重新登录";
        } else {
            List<EvaluateVo> evaluateVos = evaluateService.selectAllByUId(user.getuId());
            model.addAttribute("evs",evaluateVos);
            model.addAttribute("commons", new Commons());
            return "user/evaluate-list";
        }
    }
    @RequestMapping("user-evaluate-del")
    @ResponseBody
    public String evaluateDel(String eId){
        evaluateService.del(eId);
        return "success";
    }

    @RequestMapping("user-courseLike")
    @ResponseBody
    public String userCourseLike(String cId,String exist){
        System.out.println("收藏:"+cId+exist);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null||exist==null) {
            return "重新登录";
        } else {
            if (exist.equals("未收藏")){
                courseUserService.add(user.getuId(),cId);
                return "已收藏";
            }else {
                courseUserService.del(user.getuId(),cId);
                return "未收藏";
            }
        }
    }
    @RequestMapping("user-course-evaluate")
    @ResponseBody
    public String userEvaluate(String cId,String text,String remark){
        System.out.println(cId+text+remark);
        String s="";
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null||cId==null) {
            return s="重新 登录";
        } else {
            if (StringUtils.isNotBlank(text)&&StringUtils.isNotBlank(remark)) {
                evaluateService.add(user.getuId(), cId, text, remark);
            }
            else {
                return s="评价错误";
            }
        }
        return s="success";
    }
    @RequestMapping("user-material-evaluate")
    @ResponseBody
    public String userEvaluateToMaterial(String mId,String text,String remark){
        System.out.println(mId+text+remark);
        String s="";
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null||mId==null) {
            return s="重新 登录";
        } else {
            if (StringUtils.isNotBlank(text)&&StringUtils.isNotBlank(remark)) {
                evaluateService.addByMId(user.getuId(), mId, text, remark);
            }
            else {
                return s="评价错误";
            }
        }
        return s="success";
    }
    @RequestMapping("user-exam-evaluate")
    @ResponseBody
    public String userEvaluateToExam( String eId,  String text,  String remark){
        System.out.println("考试："+eId+","+text+remark);
        String s="";
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null||eId==null) {
            return s="重新 登录";
        } else {
            if (StringUtils.isNotBlank(text)&&StringUtils.isNotBlank(remark)) {
                evaluateService.addByEId(user.getuId(), eId, text, remark);
            }
            else {
                return s="评价错误";
            }
        }
        return s="success";
    }

    /**
     * 聊天页面跳转
     * @param tId 老师id
     * @return
     */
    @RequestMapping("user-chat.html")
    public String userChatToTeacher(String tId,Model model,String qId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getuId() == null) {
            return "userLogin";
        } else {
            model.addAttribute("uId",user.getuId());
            model.addAttribute("uName",user.getuName());
            //有qId为回复消息，先将rabbitmq中信息传递过去
            if (StringUtils.isNotBlank(qId)) {
                RaQueue raQueue = queueService.selectById(qId);
                String msg = myRabbitmq.receive(raQueue.getQueueName());//rabbitmq中的信息
                queueService.update(qId);
                model.addAttribute("toUId",raQueue.getFromUid());//回复发送过来的用户
                model.addAttribute("msg",userService.selectById(raQueue.getFromUid()).getuName()+":"+msg);
            }else {//无qId为第一次发起消息
                model.addAttribute("msg","");
                model.addAttribute("toUId", teacherService.selectById(tId).getuId());
            }
            return "websocket";
        }
    }
   @RequestMapping("user-queue-list.html")
    public String userQueueList(Model model){
       User user = (User) SecurityUtils.getSubject().getPrincipal();
       if (user == null || user.getuId() == null) {
           return "userLogin";
       } else {
           List<RaQueueVo> raQueueVos = queueService.selectAllByToUIdAndState(user.getuId());
           model.addAttribute("raQueueVos",raQueueVos);
           model.addAttribute("commons",new Commons());
           return "user/queue-list";
       }
   }
}
