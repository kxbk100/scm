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

import com.scm.model.ContentGetModel;
import com.scm.model.ContentPostModel;
import com.scm.model.UserModel;
import com.scm.service.ContentService;
import com.scm.service.UserService;
import com.scm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MainController {
    private final ContentService contentService;

    @Autowired
    public MainController(ContentService contentService) {
        this.contentService = contentService;
    }
    @Autowired
    private UserService userService;
//=============GET================

    @RequestMapping(value = "/scm/teachers",method = RequestMethod.GET)
    @ResponseBody
    public List<ContentGetModel> getteachers(){
        return contentService.GetContentlistByFirst("师资队伍建设");
    }


    @RequestMapping(value = "/scm/talents",method = RequestMethod.GET)
    @ResponseBody
    public List<ContentGetModel> gettalents(){
        return contentService.GetContentlistByFirst("人才培养");
    }


    @RequestMapping(value = "/scm/social",method = RequestMethod.GET)
    @ResponseBody
    public List<ContentGetModel> getsocial(){
        return contentService.GetContentlistByFirst("科学研究与社会服务");
    }


    @RequestMapping(value = "/scm/subject",method = RequestMethod.GET)
    @ResponseBody
    public List<ContentGetModel> getsubject(){
        return contentService.GetContentlistByFirst("学科影响力");
    }


    @RequestMapping(value = "/scm/international",method = RequestMethod.GET)
    @ResponseBody
    public List<ContentGetModel> getinternational(){
        return contentService.GetContentlistByFirst("国际合作与交流");
    }

//=============POST================

    @RequestMapping(value = {"/scm/teachers","/scm/talents","/scm/social","/scm/subject","/scm/international"},method = RequestMethod.POST)
    @ResponseBody
    public List<ContentPostModel> postteachers(@RequestParam List<ContentPostModel> contentPostModelList) {
        //更新数据库,按照得到的post数据
        return contentService.UpdateContent(contentPostModelList);//保存了之后返回修改的数据(直接返回了提交的数据)
    }

    /**
     * 用户登录，密码使用MD5校验
     * @param user
     * @return 用户不存在返回-1，密码错误返回0，正确登录返回用户的名字
     */
    @RequestMapping(value = "/scm",method = RequestMethod.POST)
    @ResponseBody
    public String login(UserModel user, HttpSession session){
        UserModel queryUser=userService.findUserByUserName(user.getUsername());
        if (queryUser==null){
            return "-1";
        }
        if(queryUser.getPassword().equals(MD5Util.MD5Encode(user.getPassword(),"utf-8"))){
            session.setAttribute("user",queryUser);
            return queryUser.getName();
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


//    @RequestMapping(value = ,method = RequestMethod.POST)
//    public void posttalents(@RequestParam ContentPostModel contentPostModel){
//
//    }
//    @RequestMapping(value = ,method = RequestMethod.POST)
//    public void postsocial(@RequestParam ContentPostModel contentPostModel){
//
//    }
//    @RequestMapping(value = ,method = RequestMethod.POST)
//    public void postsubject(@RequestParam ContentPostModel contentPostModel){
//
//    }
//    @RequestMapping(value = ,method = RequestMethod.POST)
//    public void postinternational(@RequestParam ContentPostModel contentPostModel){
//
//    }


}
