package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.entity.Admin;
import com.lzc.teachingInteraction.entity.Notice;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.service.AdminService;
import com.lzc.teachingInteraction.service.NoticeService;
import com.lzc.teachingInteraction.utils.Commons;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminNoticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    AdminService adminService;

    /**
     * 通过考试id查询它的
     * @return
     */
    @RequestMapping("admin-notice-list.html")
    public String noticeList( Model model){
        List<Notice> notices = noticeService.selectAll();
        model.addAttribute("notices",notices);
        model.addAttribute("commons",new Commons());
        return "admin/notice/list";
    }

    /**
     * 跳转到增加页面
     * @param model
     * @return
     */
    @RequestMapping("admin-notice-add.html")
    public String noticeAddUi(Model model ){
    
        return "admin/notice/add";
    }

    /**
     * 一个公告的增加
     * @param notice
     * @return
     */
    @RequestMapping("admin-notice-add")
    @ResponseBody
    public String noticeAdd(Notice notice){
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        if (user==null&&user.getuId()!=null){
            return "login/userLogin";
        }
        else {
            Admin admin = adminService.selectByUId(user.getuId());
            notice.setaId(admin.getaId());
            System.out.println("公告的增加" + notice);
            noticeService.add(notice);
            return "success";
        }
    }

    /**
     * 编辑页面跳转
     * @param model
     * @return
     */
    @RequestMapping("admin-notice-update.html")
    public String noticeUpdateUi(String nId,Model model){
         model.addAttribute("notice",noticeService.selectById(nId));
        return "admin/notice/update";
    }

    /**
     * 跟新的实现
     * @param notice
     * @return
     */
    @RequestMapping("admin-notice-update")
    @ResponseBody
    public String noticeUpdate(Notice notice){
        System.out.println("跟新："+notice);
        noticeService.update(notice);
        return "success";
    }

    /**
     * 删除该公告
     * @return
     */
    @RequestMapping("admin-notice-del")
    @ResponseBody
    public String noticeDel(String nId){
        System.out.println("删除"+nId);
        noticeService.del(nId);
        return "success";
    }
    /**
     * 启用公告
     * @param nId
     * @return
     */
    @RequestMapping("admin-start-notice")
    @ResponseBody
    public String userStart(String nId){
        noticeService.start(nId);
        return "success";
    }

    /**
     * jin用公告
     * @param nId
     * @return
     */
    @RequestMapping("admin-stop-notice")
    @ResponseBody
    public String userStop(String nId){
        noticeService.stop(nId);
        return "success";
    }
}
