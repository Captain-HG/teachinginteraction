package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Student;
import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.AdminService;
import com.lzc.teachingInteraction.service.StudentService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.utils.FileUtils;
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

/**
 * @author 水银队长
 *  管理员的关于用户操作的管理
 */
@Controller
public class AdminUserController {
     @Autowired
     UserService userService;
     @Autowired
     StudentService studentService;
     @Autowired
    TeacherService teacherService;
     @Autowired
    AdminService adminService;

    /**
     * 用户列表
     * @param model
     * @return
     */
     @RequestMapping("admin-user-list.html")
     public String userList(Model model){
         List<User> users = userService.selectAll();
         model.addAttribute("userList",users);
         model.addAttribute("commons",new Commons());
         return "admin/user/list";
     }

    /**
     * 跳转到增加页面
     * @param model
     * @return
     */
     @RequestMapping("admin-user-add.html")
     public String userAddUi(Model model){
         return "admin/user/add";
     }
    /**
     * 管理员的用户增加
     * @return
     */
   @RequestMapping("admin-user-add")
   @ResponseBody
    public String userAdd(User user,HttpServletRequest req, MultipartHttpServletRequest multiReq,String schoolName,String grade){
       System.out.println("学校："+schoolName+",年级："+grade);
       String headImgUrl = FileUtils.UploadFile(req, multiReq);
       System.out.println("头像地址："+headImgUrl);
       user.setHeadimg(headImgUrl);
       userService.add(user,schoolName,grade);
       return "success";
   }

    /**
     * 跳转到修改页面
     * @return
     */
   @RequestMapping("admin-user-update.html")
    public String userUpdateUi(String uId,Model model){
       System.out.println("传输id："+uId);
       User user = userService.selectById(uId);
       System.out.println("修改信息的user："+user);
       Byte type = user.getType();
       switch(type){
           case WebConst.USER_TYPE_STUDENT:
               Student student = studentService.selectByUId(uId);
               System.out.println("修改信息得学生："+student);
               model.addAttribute("grade",student.getsGrade());
               model.addAttribute("schoolName",student.getSchoolName());
               break;
           case WebConst.USER_TYPE_TEACHER:
               Teacher teacher = teacherService.selectByUId(user.getuId());
               model.addAttribute("schoolName",teacher.getSchoolName());
               break;
           case WebConst.USER_TYPE_ADNIN:
               break;
       }
       model.addAttribute("user",user);
       System.out.println("传输用户："+user);
       return "admin/user/update";
   }

    /**
     * 修改的实现
     * @param model
     * @param user
     * @return
     */
   @RequestMapping("admin-user-update")
   @ResponseBody
   public String userUpdate(Model model, User user, HttpServletRequest req,
                            MultipartHttpServletRequest multiReq,
                            String schoolName,String grade){
       System.out.println("更新时:"+user);
//       System.out.println(multiReq);
       User user1  = (User) SecurityUtils.getSubject().getPrincipal();//shiro中的user数据
       if(user.getuId().equals(user1.getuId())){//如果相等说明为本人修改自己数据，更新保存在shiro的user数据
           user1.setSex(user.getSex());
           user1.setuName(user.getuName());
           user1.setOntime(user.getOntime());
           user1.setRemark(user.getRemark());
           user1.setDetail(user.getDetail());
           user1.setAccount(user.getAccount());
           user1.setHeadimg(user.getHeadimg());
       }
           String headImgUrl = FileUtils.UploadFile(req, multiReq);
           System.out.println("头像地址："+headImgUrl);
           user.setHeadimg(headImgUrl);

      userService.update(user,schoolName,grade);
       return "success";
   }

    /**
     *删除功能的实现
     * @return
     */
   @RequestMapping("admin-user-del")
   @ResponseBody
    public String userDel(String uId){
       userService.del(uId);
       return "success";
   }

    /**
     * 启用用户
     * @param uId
     * @return
     */
   @RequestMapping("admin-start-user")
   @ResponseBody
   public String userStart(String uId){
        userService.start(uId);
       return "success";
   }

    /**
     * jin用用户
     * @param uId
     * @return
     */
   @RequestMapping("admin-stop-user")
   @ResponseBody
   public String userStop(String uId){
       userService.stop(uId);
       return "success";
   }

    /**
     * ajax实现用户验证
     * @param id
     * @param account
     * @return
     */
   @RequestMapping("admin-user-accountAjaxRegister")
   @ResponseBody
    public String userAjaxAccount(String id,String account){
       System.out.println("ajax"+id+account);
       String str="";
       User user = userService.selectByAccount(account);
       if (user==null){
           str="true";
       }
       else{
           if (StringUtils.isNotBlank(id)){
               User userById = userService.selectById(id);
               if (user!=null&&userById.getAccount().equals(account)){
                   str="true";
               }else {
                   str="账号已存在，或为空";
               }
           }
           else {
               str="账号已存在";
           }
       }
       return str;
   }

    /**
     * 修改密码页面
     * @param uId
     * @param model
     * @return
     */
   @RequestMapping("admin-user-change-password.html")
    public String userChangePassword(String uId,Model model){
       System.out.println(uId);
       User user = userService.selectById(uId);
       model.addAttribute("user",user);
       return "admin/user/change-password";
   }

    /**
     * 修改密码
     * @param uId
     * @param password
     * @return
     */
   @RequestMapping("admin-user-change-password")
   @ResponseBody
    public String userChangePassword(String uId,String password){
       System.out.println("userId:"+uId+",密码"+password);
       User user = userService.selectById(uId);
       System.out.println("修密码："+user);
       user.setPassword(password);
       userService.update(user, null,null);
       return "success";
   }

    /**
     * 个人信息显示页面
     * @param model
     * @return
     */
   @RequestMapping("admin-index-show")
    public String userShow(Model model){
       User user  = (User) SecurityUtils.getSubject().getPrincipal();
       model.addAttribute("user",user);
       model.addAttribute("commons",new Commons());
       return "admin/user/show";
   }

}
