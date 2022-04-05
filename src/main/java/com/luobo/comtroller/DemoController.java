package com.luobo.comtroller;

import com.luobo.dao.IUserDao;
import com.luobo.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IUserDao userDao;

    @GetMapping("/hello.json")
    public void hello(){
        System.out.println("hello!");
    }

    @GetMapping("/jpa.json")
    public void jpa(){
        UserPO user = userDao.findUserByUid("1");
        if(user!=null){
            System.out.println(user.toString());
        }else{
            System.out.println("not found");
        }
    }

    @GetMapping("/save.json")
    public void save(){
        UserPO userByUid = userDao.findUserByUid("2");
        if(userByUid==null){
            System.out.println("null!");
        }
        UserPO user=new UserPO(userByUid.getId(),userByUid.getUid(),userByUid.getNickName(),userByUid.getPortrait(),userByUid.getPhoneNumber(),userByUid.getMail(),userByUid.getOpenId(),userByUid.getCreateTime());
        user.setId(2);
        user.setNickName("111111");
        userDao.save(user);
    }
}
