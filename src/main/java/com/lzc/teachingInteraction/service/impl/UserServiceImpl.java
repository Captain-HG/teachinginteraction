package com.lzc.teachingInteraction.service.impl;

import com.lzc.teachingInteraction.config.WebConst;
import com.lzc.teachingInteraction.entity.Student;
import com.lzc.teachingInteraction.entity.Teacher;
import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.mapper.UserMapper;
import com.lzc.teachingInteraction.service.AdminService;
import com.lzc.teachingInteraction.service.StudentService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.DateKit;
import com.lzc.teachingInteraction.utils.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional//增加事务
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;


    @Override
    public User selectById(String uId) {
        return userMapper.selectByPrimaryKey(uId);
    }

    @Override
    public List<User> selectByTeacher() {
        return userMapper.selectByType((int)WebConst.USER_TYPE_TEACHER);
    }

    @Override
    public String loginSure(String account, String password) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("account",account);
        map.put("password",password);
        List<User> userList = userMapper.selectByAccountAndPassword(map);
        if (userList!=null&&userList.size()>=1)
        {
            return "success";
        }
        else {
            return "您的账号或密码输入有误，请重试！！";
        }

    }

    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override

    public void add(User user, String schoolName, String grade) {
        Byte type = user.getType();
        user.setuId(UUID.UU32());
        user.setCtime(DateKit.getCurrentUnixTime());
        //默认状态为可用
        user.setState(WebConst.USER_STATE_YESUSE);
        userMapper.insert(user);
        switch(type){
            case WebConst.USER_TYPE_STUDENT:
           studentService.add(user.getuId(),schoolName,grade);break;
            case WebConst.USER_TYPE_TEACHER:
               teacherService.add(user.getuId(),schoolName);break;
            case WebConst.USER_TYPE_ADNIN:
               adminService.add(user.getuId());break;
        }

    }

    @Override
    public void update(User user, String schoolName, String grade) {
        if (StringUtils.isNotBlank(schoolName)) {
            if (user.getType()==null){//说明是本人在进行修改，那么可以从shiro中取得他的type
                User user1 = (User) SecurityUtils.getSubject().getPrincipal();
               user.setType(user1.getType());//将shiro的type赋值到要更新的对象中
            }
            Byte type = user.getType();
            switch (type) {
                case WebConst.USER_TYPE_STUDENT:
                    studentService.checkAndUpdate(user.getuId(), schoolName, grade);
                    break;
                case WebConst.USER_TYPE_TEACHER:
                    teacherService.checkAndUpdate(user.getuId(), schoolName);
                    break;
                case WebConst.USER_TYPE_ADNIN:

//                    adminService.checkAndUpdate(user.getuId());
                    break;
            }

        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void del(String uId) {
        User user = userMapper.selectByPrimaryKey(uId);
        System.out.println(user);
        userMapper.delete(user);
    }

    @Override
    @Transactional
    public void start(String uId) {
        User user = userMapper.selectByPrimaryKey(uId);
        //首先判断身份
        if(user.getType().equals(WebConst.USER_TYPE_STUDENT)){
            Student student = studentService.selectByUId(uId);
            studentService.changeState(student.getsId(),WebConst.USER_STATE_YESUSE);
        }else if (user.getType().equals(WebConst.USER_TYPE_TEACHER)){
            Teacher teacher = teacherService.selectByUId(uId);
            teacherService.changeState(teacher.gettId(),WebConst.USER_STATE_YESUSE);
        }else{
            System.out.println("admin no change");
        }
        user.setState(WebConst.USER_STATE_YESUSE);
        userMapper.updateByPrimaryKeySelective(user);

    }

    @Override
    @Transactional
    public void stop(String uId) {
        User user = userMapper.selectByPrimaryKey(uId);
        if(user.getType().equals(WebConst.USER_TYPE_STUDENT)){
            Student student = studentService.selectByUId(uId);
            studentService.changeState(student.getsId(),WebConst.USER_STATE_NOUSE);
        }else if (user.getType().equals(WebConst.USER_TYPE_TEACHER)){
            Teacher teacher = teacherService.selectByUId(uId);
            teacherService.changeState(teacher.gettId(),WebConst.USER_STATE_NOUSE);
        }else{
            System.out.println("admin no change");
        }
        user.setState(WebConst.USER_STATE_NOUSE);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void setOntime(User user) {
        user.setOntime(DateKit.getCurrentUnixTime());
        userMapper.updateByPrimaryKeySelective(user);
    }

}
