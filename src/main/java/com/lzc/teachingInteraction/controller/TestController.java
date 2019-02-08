package com.lzc.teachingInteraction.controller;

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
    @RequestMapping("test2")
    public String test2(){
        return "test2";
    }
    @RequestMapping(value = "testUploadFile", method = RequestMethod.POST)
    @ResponseBody
    public void testUploadFile(HttpServletRequest req,
                               MultipartHttpServletRequest multiReq) {
        // 获取上传文件的路径
        String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
        System.out.println("uploadFlePath:" + uploadFilePath);
        // 截取上传文件的文件名
        String uploadFileName = uploadFilePath.substring(
                uploadFilePath.lastIndexOf('\\') + 1, uploadFilePath.indexOf('.'));
        System.out.println("multiReq.getFile()" + uploadFileName);
        // 截取上传文件的后缀
        String uploadFileSuffix = uploadFilePath.substring(
                uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
        System.out.println("uploadFileSuffix:" + uploadFileSuffix);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String fileNamePath="";//默认的文件存放地址
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        switch(uploadFileSuffix){
            case "txt":

              fileNamePath=".//upload/txt//";
              break;
            case "doc":
                fileNamePath=".//upload/doc//";break;
            case "docx":
                fileNamePath=".//upload/docx//";break;
            case "mp4":
                fileNamePath=".//upload/mp4//";break;
            default:
                fileNamePath=".//upload//";break;
        }
        System.out.println(fileNamePath);
        try {
            fis = (FileInputStream) multiReq.getFile("file1").getInputStream();
            File file = new File( fileNamePath+ uploadFileName
                    + ".");
            if(!file.getParentFile().exists()){ //判断文件父目录是否存在
                file.getParentFile().mkdir();
            }
            fos = new FileOutputStream(file
                    + uploadFileSuffix);

            byte[] temp = new byte[1024];
            int i = fis.read(temp);
            while (i != -1){
                fos.write(temp,0,temp.length);
                fos.flush();
                i = fis.read(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
}

