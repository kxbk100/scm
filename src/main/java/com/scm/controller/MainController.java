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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.registry.infomodel.User;


@Controller
@RequestMapping("/scm")
public class MainController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String checkLogin(){
        return "1";
    }

    @PostMapping(value = "/index")
    public String showIndex(){
        return "fuck";
    }
}