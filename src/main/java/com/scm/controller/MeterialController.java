package com.scm.controller;


/*
管理员查看材料提交  /scm/material/admin/show
管理员审核材料提交 /scm/material/admin/check
教师材料的提交上传 /scm/material/teachers/upload
教师材料提交记录的查看 /scm/meterial/teachers/show
教师材料提交记录的修改 /scm/material/teachers/modify
 */
import com.scm.model.OtherModel;
import com.scm.model.RecordModel;
import com.scm.service.MeterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/scm/material/")
public class MeterialController {

    @Autowired
    private MeterialService meterialService;

    @RequestMapping(value = "admin/show",method = RequestMethod.GET)
    @ResponseBody
    public List<Pair<RecordModel,?>> showAdminMeterial(){
        List<Pair<RecordModel,?>> pairs=new ArrayList<>();
        List<RecordModel> recordModels=meterialService.findAllRecord();
        for(RecordModel model:recordModels){
            Pair pair;
            switch (model.getType()){
                case 0:
                    OtherModel otherModel=meterialService.findOtherById(model.getRecordId());
                    model.setName(otherModel.getPointModel().getContent());
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
        return pairs;
    }


    @RequestMapping(value = "scm/meterial/teachers/show",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void TGetMaterialShow(){

    }
    @RequestMapping(value = "/scm/meterial/admin/show",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void AGetMaterialShow(){

    }

    @RequestMapping(value = "/scm/material/teachers/modify",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void TPostMaterialModify(){

    }
    @RequestMapping(value = "/scm/material/admin/check",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void APostMaterialCheck(){

    }

    @RequestMapping(value = "/scm/material/teachers/upload",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void TPostMaterialUpload(){

    }



}
