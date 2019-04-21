package com.lzc.teachingInteraction;

import com.lzc.teachingInteraction.entity.User;
import com.lzc.teachingInteraction.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.cs.ext.GBK;

import java.io.UnsupportedEncodingException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeachinginteractionApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() throws UnsupportedEncodingException {
        String s="abcdefg";
        System.out.println(s.substring(0));
        System.out.println(s.substring(2,3));
        System.out.println(s.charAt(0));
        String  c = String.valueOf(s.charAt(1));
        System.out.println(c.toUpperCase());
        String s1 = c.toUpperCase();
        System.out.println(s1.toLowerCase());
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
    @Test
    public void maopao(){
        int[] ints={1,5,6,28,2,5};
        for(int i=0;i<ints.length-1;i++){
            for (int j=0;j<ints.length-1-i;j++){
               if (ints[j]>ints[j+1])
               {
               int temp=ints[j];
               ints[j]=ints[j+1];
               ints[j+1]=temp;
               }
            }
        }
        System.out.println(ints);
        for (int is:ints){
            System.out.println(is+",");
        }

    }
    @Test
    public void test03() {
        Map<String,String> map=new HashMap<String, String>();
        map.put("account","132");
        map.put("password","123");
        List<User> users = userMapper.selectByAccountAndPassword(map);
        System.out.println(users);
    }

}

