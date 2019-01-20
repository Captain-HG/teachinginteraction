package com.lzc.teachingInteraction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户首页的设计实现
 */
@Controller
public class UserIndexController {
    /**
     * 首页
     * @return
     */
    @RequestMapping("index.html")
    public String userIndex(){
        return "index/index";
    }
    /**
     * 关于我们
     */
    @RequestMapping("about-us.html")
    public  String  indexAboutUs(){
        return "index/about-us";
    }
    /**
     * 我们的课程
     * @return
     */
    @RequestMapping("course.html")
    public String course(){
        return "index/course";
    }
    /**
     * 联系我们
     * @return
     */
    @RequestMapping("contact.html")
    public String contact(){
        return "index/contact";
    }

}
