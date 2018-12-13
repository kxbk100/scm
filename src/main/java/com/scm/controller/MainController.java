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

import com.scm.model.IndexGetModel;
import com.scm.model.UserModel;
import com.scm.service.UserService;
import com.scm.model.ContentGetModel;
import com.scm.model.ContentPostModel;
import com.scm.service.ContentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private final ContentService contentService;

    @Autowired
    public MainController(ContentService contentService) {
        this.contentService = contentService;
    }
    @Autowired
    private UserService userService;
//=============GET================

    @RequestMapping(value = "/scm/index",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public IndexGetModel getIndex(HttpSession session){
        IndexGetModel indexGetModel = contentService.GetIndexData();
//        indexGetModel.setUsername(((UserModel)session.getAttribute("user")).getUsername());
        indexGetModel.setUsername("NITAMADE");//TEST
        return indexGetModel;
    }

    @RequestMapping(value = "/scm/teachers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContentGetModel> getteachers(){
        return contentService.GetContentlistByFirst("师资队伍建设");
    }


    @RequestMapping(value = "/scm/talents",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContentGetModel> gettalents(){
        return contentService.GetContentlistByFirst("人才培养");
    }


    @RequestMapping(value = "/scm/social",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContentGetModel> getsocial(){
        return contentService.GetContentlistByFirst("科学研究与社会服务水平");
    }


    @RequestMapping(value = "/scm/subject",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContentGetModel> getsubject(){
        return contentService.GetContentlistByFirst("学科影响力");
    }


    @RequestMapping(value = "/scm/international",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContentGetModel> getinternational(){
        return contentService.GetContentlistByFirst("国际合作与交流");
    }

//=============POST================

    @RequestMapping(value = {"/scm/teachers","/scm/talents","/scm/social","/scm/subject","/scm/international"},method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<ContentPostModel> postteachers(@RequestBody List<ContentPostModel> contentPostModelList) {
        //更新数据库,按照得到的post数据
        return contentService.UpdateContent(contentPostModelList);//保存了之后返回修改的数据(直接返回了提交的数据)
    }

    @RequestMapping(value = "/scm",method = RequestMethod.POST)
    @ResponseBody
    public String login(UserModel user){
        UserModel queryUser=userService.findUserByUserName(user.getUsername());
        if (queryUser==null){
            return "-1";
        }
        if(queryUser.getPassword().equals(user.getPassword())){
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
}
