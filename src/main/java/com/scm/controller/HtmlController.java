package com.scm.controller;

import com.scm.model.RecordModel;
import com.scm.pageModel.RecordPageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/zjscm/")
public class HtmlController {
    @RequestMapping(value = "amaterial",method = RequestMethod.GET)
    public String showAdminMaterial(){
        System.out.println("fuck");
        return "amaterial";
    }
}
