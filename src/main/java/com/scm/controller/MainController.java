package com.scm.controller;
/*
post
登录  /scm
欢迎页 /scm/index

get
查看师资队伍建设数据  /scm/teachers
查看人才培养数据    /scm/talents
查看社会研究与服务数据 /scm/social
查看学科影响力数据   /scm/subject
查看国际合作与交流数据 /scm/international

post
设置师资队伍建设数据 /scm/teachers
设置人才培养数据 /scm/talents
设置社会研究与服务数据 /scm/social
设置学科影响力数据 /scm/subject
设置国际合作与交流数据 /scm/international
*/

import com.scm.model.UserModel;
import com.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    @Autowired
    private UserService userService;




//=============GET================
    @RequestMapping(value = "/scm/teachers",method = RequestMethod.GET)
    public void getteachers(){
        //返回数据

    }
    @RequestMapping(value = "/scm/talents",method = RequestMethod.GET)
    public void gettalents(){

    }
    @RequestMapping(value = "/scm/social",method = RequestMethod.GET)
    public void getsocial(){

    }
    @RequestMapping(value = "/scm/subject",method = RequestMethod.GET)
    public void getsubject(){

    }
    @RequestMapping(value = "/scm/international",method = RequestMethod.GET)
    public void getinternational(){

    }
//=============POST================
    @RequestMapping(value = "/scm",method = RequestMethod.POST)
    @ResponseBody
    public String login(UserModel user){
        UserModel queryUser=userService.findUserByUserName(user.getUserName());
        if (queryUser==null){
            return "-1";
        }
        if(queryUser.getPassWord().equals(user.getPassWord())){
            return "1";
        }else {
            return "0";
        }
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public UserModel test(){
        UserModel userModel=userService.findUserByUserName("123456");
        return userModel;
    }

    @RequestMapping(value = "/scm/teachers",method = RequestMethod.POST)
    public void postteachers(){

    }
    @RequestMapping(value = "/scm/talents",method = RequestMethod.POST)
    public void posttalents(){

    }
    @RequestMapping(value = "/scm/social",method = RequestMethod.POST)
    public void postsocial(){

    }
    @RequestMapping(value = "/scm/subject",method = RequestMethod.POST)
    public void postsubject(){

    }
    @RequestMapping(value = "/scm/international",method = RequestMethod.POST)
    public void postinternational(){

    }


}
