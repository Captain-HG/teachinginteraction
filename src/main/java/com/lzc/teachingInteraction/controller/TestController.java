package com.lzc.teachingInteraction.controller;

import com.lzc.teachingInteraction.service.MailService;
import com.lzc.teachingInteraction.utils.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class TestController {
//    @Autowired
//    private JavaMailSender mailSender;



    @RequestMapping("test2")
    public String test2(){
        return "test2";
    }
    @RequestMapping(value = "testUploadFile", method = RequestMethod.POST)
    @ResponseBody
    public void testUploadFile(HttpServletRequest req,
                               MultipartHttpServletRequest multiReq) {
        String s = FileUtils.UploadFile(req, multiReq);
        System.out.println(s);
    }
//    public void testUploadFile(HttpServletRequest req,
//                               MultipartHttpServletRequest multiReq) {
//        // 获取上传文件的路径
//        String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
//        System.out.println("uploadFlePath:" + uploadFilePath);
//        // 截取上传文件的文件名
//        String uploadFileName = uploadFilePath.substring(
//                uploadFilePath.lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));
//        System.out.println("multiReq.getFile()" + uploadFileName);
//        // 截取上传文件的后缀
//        String uploadFileSuffix = uploadFilePath.substring(
//                uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
//        System.out.println("uploadFileSuffix:" + uploadFileSuffix);
//        FileOutputStream fos = null;
//        FileInputStream fis = null;
//        String fileNamePath="";//默认的文件存放地址
//        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        switch(uploadFileSuffix){
//            case "txt":
//
//              fileNamePath=".//upload/txt//";
//              break;
//            case "doc":
//                fileNamePath=".//upload/doc//";break;
//            case "docx":
//                fileNamePath=".//upload/docx//";break;
//            case "mp4":
//                fileNamePath=".//upload/mp4//";break;
//            case "jpg":
//                fileNamePath="./upload/jpg//";break;
//            default:
//                fileNamePath=".//upload//";break;
//        }
//        System.out.println(fileNamePath);
//        try {
//            fis = (FileInputStream) multiReq.getFile("file1").getInputStream();
//            File file = new File( fileNamePath+ uploadFileName
//                    + ".");
//            if(!file.getParentFile().exists()){ //判断文件父目录是否存在
//                file.getParentFile().mkdir();
//            }
//            fos = new FileOutputStream(file
//                    + uploadFileSuffix);
//
//            byte[] temp = new byte[1024];
//            int i = fis.read(temp);
//            while (i != -1){
//                fos.write(temp,0,temp.length);
//                fos.flush();
//                i = fis.read(temp);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    /**
     * 单文件上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return" 上传成功";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return"上传失败," ;
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," ;
            }
        } else {
            return "上传失败，因为文件为空.";
        }
    }
//    @RequestMapping("/download")
//    @ResponseBody
//    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
//        String fileName = ".//upload/txt/test.txt";// 文件名
//        if (fileName != null) {
//            //设置文件路径
//            File file = new File(fileName);
//            //File file = new File(realPath , fileName);
//            if (file.exists()) {
//                response.setContentType("application/octet-stream");//
//                response.setHeader("content-type", "application/octet-stream");
//                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
//                 byte[] buffer = new byte[1024];
//                FileInputStream fis = null;
//                BufferedInputStream bis = null;
//                try {
//                    fis = new FileInputStream(file);
//                    bis = new BufferedInputStream(fis);
//                    OutputStream os = response.getOutputStream();
//                    int i = bis.read(buffer);
//                    while (i != -1) {
//                        os.write(buffer, 0, i);
//                        i = bis.read(buffer);
//                    }
//                    return "下载成功";
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    if (bis != null) {
//                        try {
//                            bis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (fis != null) {
//                        try {
//                            fis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//        return "下载失败";
//    }
    @RequestMapping("test01")
    public String test01(Model model){
        String s="1";
        model.addAttribute("mmp",s);
        return "test01";
    }

    @RequestMapping("test04")
    public String test04(){
        return "test04";
    }
    @RequestMapping("test09")
    public String test06(){
        return "test09";
    }
    /**
     * 测试shiro标签
     * @return
     */
    @RequestMapping("testShiro")
    public String testShiro(){
        return "testShiro";
    }

    @RequestMapping("testFileShow")
    public String testFileShow(Model model,String url){
        System.out.println(url);
        model.addAttribute("url",url);
        return "test06";
    }

//    /**
//     * 简单邮件发送
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/test/mail/send")
//    @ResponseBody
//    public String sendSimpleMail() throws Exception {
////        SimpleMailMessage message = new SimpleMailMessage();
////        message.setTo("318361965@qq.com");
////        message.setFrom("1436899024@qq.com");
////        message.setSubject("主题：简单邮件");
////        message.setText("测试邮件内容");
////        mailSender.send(message);
//        String s = mailService.sendMailWithImg("1179091849@qq.com", "图片", "图片邮件", "D:/lufei.jpg");
//        return s;
//    }

//    @RequestMapping("/test/mail/sendWithFile")
//    @ResponseBody
//    public String sendMail(){
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setTo("318361965@qq.com");
//            helper.setFrom("1436899024@qq.com");
//            helper.setSubject("主题：附件邮件");
//            helper.setText("附件邮件内容", true);
//            String filePath="D:/sql.txt";
//            FileSystemResource file = new FileSystemResource(new File(filePath));
//            String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
//            String filePath1="D:/sql2.txt";
//            FileSystemResource file1 = new FileSystemResource(new File(filePath1));
//            String fileName1 = filePath1.substring(filePath1.lastIndexOf(File.separator)+1);
//            helper.addAttachment(fileName,file);
//            helper.addAttachment(fileName1,file1);
//            mailSender.send(mimeMessage);
//            System.out.println("带附件的邮件已经发送。");
//        } catch (MessagingException e) {
//            System.out.println(e.getMessage());
//
//        }
//        return "ok";
//    }

}

