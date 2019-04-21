package com.lzc.teachingInteraction.service;

public interface MailService {
    /** 简单发送*/
    void sendSimpleMail(String to,String text,String subject,String adId);
    /** 带图片的发送*/
    String sendMailWithImg(String to,String text,String subject,String imgPath);
    /** 带附件的  */
    String sendMailWithFile(String to,String text,String subject,String filePath);
}
