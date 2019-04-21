package com.lzc.teachingInteraction.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lzc
 * @Date: 2019-2-15 15:13
 * @Description: 上传文件工具类
 */
public class FileUtils {
    //下载文件
    public static String downloadFile(HttpServletRequest request, HttpServletResponse response,String fileName) {
        System.out.println(fileName);
        if (fileName != null&&fileName.length()!=0) {
            //设置文件路径
            File file = new File(fileName);
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/octet-stream");//
                response.setHeader("content-type", "application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
    //文件上传
    public static String UploadFile(HttpServletRequest req,
                               MultipartHttpServletRequest multiReq) {
        // 获取上传文件的路径
        System.out.println("文件上传");
        MultipartFile file1 = multiReq.getFile("file1");
        if (file1==null){
            return null;
        }
        String uploadFilePath = file1.getOriginalFilename();

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

        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        switch(uploadFileSuffix){
//            case "txt":
//
//                fileNamePath=".//upload/txt/";
//                break;
//            case "doc":
//                fileNamePath=".//upload/doc/";break;
//            case "docx":
//                fileNamePath=".//upload/docx/";break;
//            case "mp4":
//                fileNamePath=".//upload/mp4/";break;
//            case "jpg":
//                fileNamePath=".//upload/jpg/";break;
//            default:
//                fileNamePath=".//upload/";break;
//        }

        try {
            fis = (FileInputStream) multiReq.getFile("file1").getInputStream();
            File file = new File( fileuploadFileName(uploadFileSuffix)+ uploadFileName
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
            return fileuploadFileName(uploadFileSuffix)+uploadFileName+ "."+uploadFileSuffix;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
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
    //多文件上传
    public  static List<String> handleFileUpload(HttpServletRequest request) {
       List<String> list = new ArrayList<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file1");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    String uploadFilePath = file.getOriginalFilename();
                    System.out.println("uploadFlePath:" + uploadFilePath);
                    // 截取上传文件的文件名
                    String uploadFileName = uploadFilePath
                            .substring(uploadFilePath.lastIndexOf('\\') + 1,
                                    uploadFilePath.indexOf('.'));
                    System.out.println("multiReq.getFile()" + uploadFileName);
                    // 截取上传文件的后缀
                    String uploadFileSuffix = uploadFilePath.substring(
                            uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
                    System.out.println("uploadFileSuffix:" + uploadFileSuffix);


                    stream = new BufferedOutputStream(new FileOutputStream(new File(
                            fileuploadFileName(uploadFileSuffix)+ uploadFileName + "." + uploadFileSuffix)));
                    byte[] bytes = file.getBytes();
                    stream.write(bytes,0,bytes.length);
                    list.add(fileuploadFileName(uploadFileSuffix)+uploadFileName+ "."+uploadFileSuffix);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (stream != null) {
                            stream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("上传文件为空");
            }
        }
        System.out.println("文件接受成功了");
        return list;
    }
    //上传文件地址生成
    private static String fileuploadFileName(String uploadFileSuffix){
        String fileNamePath="";//默认的文件存放地址
        switch(uploadFileSuffix){
            case "txt":

                fileNamePath=".//upload/txt/";
                break;
            case "doc":
                fileNamePath=".//upload/doc/";break;
            case "docx":
                fileNamePath=".//upload/docx/";break;
            case "mp4":
                fileNamePath=".//upload/mp4/";break;
            case "jpg":
                fileNamePath=".//upload/jpg/";break;
            default:
                fileNamePath=".//upload/";break;
        }
        return fileNamePath;
    }
}
