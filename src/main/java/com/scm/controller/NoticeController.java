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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/scm/notices/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    /**
     * 查看所有通知
     * @return
     */
    @RequestMapping(value = "show",method = RequestMethod.GET)
    public List<NoticeModel> showNotice(){
        List<NoticeModel> noticeModels=noticeService.getAllNotice();
        return noticeModels;
    }

    /**
     * 发布和修改公告
     * @param model
     */
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public void postNotice(NoticeModel model){
        noticeService.save(model);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public void deleteNotice(@PathVariable int id){
        noticeService.deleteById(id);
    }
}
