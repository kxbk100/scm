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

import com.scm.model.ContentGetModel;
import com.scm.model.ContentPostModel;
import com.scm.model.UserModel;
import com.scm.service.ContentService;
import com.scm.service.UserService;
import com.scm.utils.DateUtil;
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


    @RequestMapping(value = "/scm/science",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

    @RequestMapping(value = "/scm/{part}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Integer postscmdata(@RequestBody List<ContentPostModel> contentPostModelList,@PathVariable String part) {
        //更新数据库,按照得到的post数据
        Integer result = null;
        switch(part){
            case "teachers":
                result = contentService.UpdateContent(contentPostModelList,4);
                break;
            case "talents":
                result = contentService.UpdateContent(contentPostModelList,9);
                break;
            case "science":
                result = contentService.UpdateContent(contentPostModelList,15);
                break;
            case "subject":
                result = contentService.UpdateContent(contentPostModelList,20);
                break;
            case "international":
                result = contentService.UpdateContent(contentPostModelList,24);
                break;
        }
        return result;//保存了之后返回修改的数据(直接返回了提交的数据)
    }

    @RequestMapping(value = "/scm/teachers/nextdeadline",method = RequestMethod.POST)
    @ResponseBody
    public Integer postteachersnextdeadline(@RequestParam String nextdeadline) {

        return contentService.SetNextDeadlineByFirst("师资队伍建设", DateUtil.StringtoDate(nextdeadline));
    }
    @RequestMapping(value = "/scm/talents/nextdeadline",method = RequestMethod.POST)
    @ResponseBody
    public Integer posttalentsnextdeadline(@RequestParam String nextdeadline){
        return contentService.SetNextDeadlineByFirst("人才培养",DateUtil.StringtoDate(nextdeadline));
    }
    @RequestMapping(value = "/scm/science/nextdeadline",method = RequestMethod.POST)
    @ResponseBody
    public Integer postsciencenextdeadline(@RequestParam String nextdeadline){
        return contentService.SetNextDeadlineByFirst("科学研究与社会服务水平",DateUtil.StringtoDate(nextdeadline));
    }
    @RequestMapping(value = "/scm/subject/nextdeadline",method = RequestMethod.POST)
    @ResponseBody
    public Integer postsubjectnextdeadline(@RequestParam String nextdeadline){
        return contentService.SetNextDeadlineByFirst("学科影响力",DateUtil.StringtoDate(nextdeadline));
    }
    @RequestMapping(value = "/scm/international/nextdeadline",method = RequestMethod.POST)
    @ResponseBody
    public Integer postinternationalnextdeadline(@RequestParam String nextdeadline){
        return contentService.SetNextDeadlineByFirst("国际合作与交流",DateUtil.StringtoDate(nextdeadline));
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
}
