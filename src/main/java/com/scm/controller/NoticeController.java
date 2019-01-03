package com.scm.controller;
/*
管理员发布通知 /scm/notices/add
管理员修改通知 /scm/notices/modify
管理员删除通知 /scm/notices/delete
教师/管理员查看通知 /scm/notices/show
 */

import com.scm.model.NoticeModel;
import com.scm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/scm/notices/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    /**
     * 查看所有通知
     * @return
     */
    @RequestMapping(value = "show",method = RequestMethod.GET)
    @ResponseBody
    public List<NoticeModel> showNotice(){
        return noticeService.getAllNotice();
    }

    /**
     * 发布和修改公告
     * @param model
     */
    @RequestMapping(value = "post",method = RequestMethod.POST)
    @ResponseBody
    public String postNotice(NoticeModel model){
        try {
            noticeService.save(model);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteNotice(@PathVariable int id){
        try{
            noticeService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
        return "1";
    }
}
