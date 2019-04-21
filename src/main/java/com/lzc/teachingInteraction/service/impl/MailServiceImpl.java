//package com.lzc.teachingInteraction.service.impl;
//
//import com.lzc.teachingInteraction.service.AdviseService;
//import com.lzc.teachingInteraction.service.MailService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//
//@Service
//public class MailServiceImpl implements MailService {
//    @Autowired
//    private JavaMailSender mailSender;
//    @Autowired
//    AdviseService adviseService;
//
//    /**
//     * 简单邮件的发送
//     * @param to 给哪个
//     * @param text 内容
//     * @param subject
//     * @return
//     */
//    @Override
//    @Transactional
//    public  void sendSimpleMail(String to,String text,String subject,String adId)  {
//        System.out.println(to+text+subject);
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setFrom("1436899024@qq.com");
//        message.setSubject(subject);
//        message.setText(text);
//        mailSender.send(message);
//        adviseService.alreadyRead(adId);
//    }
//
//    /**
//     * 带图片的发送
//     * @param to 给user
//     * @param text 内容
//     * @param subject 标题
//     * @param imgPath 图片地址
//     * @return
//     */
//    @Override
//    public String sendMailWithImg(String to, String text, String subject, String imgPath) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom("1436899024@qq.com");// 发件人
//            helper.setTo(to);// 收件人
////            //helper.setCc(ccUsers);//抄送人，使用Cc还是Bcc大家根据具体场景自己选择
////            helper.setBcc(ccUsers);//秘密抄送（发件人，收件人，抄送人都不会看到抄送给谁了）
//            helper.setSubject(subject);// 标题
//
//            String  content="<html><meta charset=\"UTF-8\"><body><h1>"+text+"</h1>"+"<h1 style='color:red'>helloWorld</h1><img src='cid:test001'/></body></html>";
//
//
//            /* 创建html内容，若不创建html标签,则图片会以附件的形式发送，而并非直接以内容显示 */
//           // String content = "<html><body>" + text + "<img src='ingId:imgUrl'></img>" + "</body></html>";
//            helper.setText(content, true);// text：内容，true:为HTML邮件（false则为普通文本邮件）
//            File file = new File(imgPath);// 创建图片文件
//            FileSystemResource resource = new FileSystemResource(file);
//            helper.addInline("test001", resource);
//            mailSender.send(mimeMessage);// 发送邮件
//             return "ok";
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return "发生未知错误";
//        }
//
//    }
//
//    @Override
//    public String sendMailWithFile(String to, String text, String subject, String filePath) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setTo(to);
//            helper.setFrom("1436899024@qq.com");
//            helper.setSubject(subject);
//            helper.setText(text, true);
//            FileSystemResource file = new FileSystemResource(new File(filePath));
//            String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
//             helper.addAttachment(fileName,file);
//            mailSender.send(mimeMessage);
//            return "带附件的邮件已经发送。";
//        } catch (MessagingException e) {
//          return "未知错误";
//        }
//    }
//
//
//}
