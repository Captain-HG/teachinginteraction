//package com.lzc.teachingInteraction.controller.admin;
//
//
//import com.lzc.teachingInteraction.entity.Advise;
//import com.lzc.teachingInteraction.service.AdviseService;
//import com.lzc.teachingInteraction.service.MailService;
//import com.lzc.teachingInteraction.service.UserService;
//import com.lzc.teachingInteraction.utils.Commons;
//import com.lzc.teachingInteraction.vo.AdviseVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//public class AdminAdviseController {
//    @Autowired
//    AdviseService adviseService;
//    @Autowired
//    MailService mailService;
//    @Autowired
//    UserService userService;
//
//    /**
//     * 建议列表
//     * @param model
//     * @return
//     */
//    @RequestMapping("admin-advise-list.html")
//    public String adviseList(Model model){
//        List<AdviseVo> adviseVos = adviseService.selectAllVo();
//        model.addAttribute("adviseVos",adviseVos);
//        model.addAttribute("commons",new Commons());
//        return "admin/advise/list";
//    }
//
//    /**
//     * 删除
//     * @param aId
//     * @return
//     */
//    @RequestMapping("admin-advise-del")
//    @ResponseBody
//    public String adviseDel(String aId){
//        adviseService.del(aId);
//        return "success";
//    }
//    /**
//     * 已读建议
//     * @param aId
//     * @return
//     */
//    @RequestMapping("admin-start-advise")
//    @ResponseBody
//    public String adviseStart(String aId){
//        adviseService.alreadyRead(aId);
//        return "success";
//    }
//
//    /**
//     * 标记未读建议
//     * @param aId
//     * @returnwei
//     */
//    @RequestMapping("admin-stop-advise")
//    @ResponseBody
//    public String adviseStop(String aId){
//        adviseService.noRead(aId);
//        return "success";
//    }
//
//    /**
//     * 跳转到发送邮件的页面
//     * @param aId
//     * @param model
//     * @return
//     */
//    @RequestMapping("admin-email-send.html")
//    public String adviseEmailUi(String aId,Model model){
//        Advise advise = adviseService.selectById(aId);
//        model.addAttribute("advise",advise);
//        model.addAttribute("userName",userService.selectById(advise.getUserId()).getuName());
//        return "admin/advise/email";
//    }
//
//    /**
//     * 邮件发送实现
//     * @param to 发送给
//     * @param text 信息内容
//     * @return
//     */
//    @RequestMapping("admin-email-send")
//    @ResponseBody
//    public String adviseEmail(String to,String text,String subject,String adId){
//        mailService.sendSimpleMail(to,text,subject,adId);
//        return "success";
//    }
//}
