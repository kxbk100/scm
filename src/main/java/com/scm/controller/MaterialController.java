package com.scm.controller;


/*
管理员查看材料提交  /scm/material/admin/show
管理员审核材料提交 /scm/material/admin/check
教师材料的提交上传 /scm/material/teachers/upload
教师材料提交记录的查看 /scm/material/teachers/show
教师材料提交记录的修改 /scm/material/teachers/modify
 */

import com.scm.model.*;
import com.scm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/scm/material/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    /**
     *
     * @return 一组Pair{first:RecordModel,second:OtherModel/TeacherModel/ItemModel/PaperModel}
     */
    @RequestMapping(value = "admin/show",method = RequestMethod.GET)
    @ResponseBody
    public List<Pair<RecordModel,?>> showAdminMaterial(){
        List<Pair<RecordModel,?>> pairs=new ArrayList<>();
        List<RecordModel> recordModels=materialService.findAllRecord();
        preparePairList(recordModels,pairs);
        return pairs;
    }


    @RequestMapping(value = "teachers/show",method = RequestMethod.GET)
    @ResponseBody
    public List<Pair<RecordModel,?>> showTeacherMaterial(HttpSession session){
        List<Pair<RecordModel,?>> pairs=new ArrayList<>();
        UserModel userModel=(UserModel) session.getAttribute("user");
//        UserModel userModel=new UserModel();
//        userModel.setId(2);
//        userModel.setName("张宇宙");
        List<RecordModel> recordModels=materialService.findByUserId(userModel.getId());
        preparePairList(recordModels,pairs);
        return pairs;
    }

    @RequestMapping(value = "teachers/modify",method = RequestMethod.POST)
    @ResponseBody
    public void TPostMaterialModify(){

    }
    @RequestMapping(value = "admin/check",method = RequestMethod.POST)
    @ResponseBody
    public void APostMaterialCheck(){

    }

    @RequestMapping(value = "teachers/upload",method = RequestMethod.GET)
    @ResponseBody
    public void TPostMaterialUpload(){

    }



    private void preparePairList(List<RecordModel> recordModels, List<Pair<RecordModel, ?>> pairs) {
        for(RecordModel model:recordModels){
            Pair<RecordModel,?> pair;
            switch (model.getType()){
                case 0:
                    OtherModel otherModel=materialService.findOtherById(model.getRecordId());
                    model.setName(otherModel.getPointModel().getContent());
                    pair=Pair.of(model,otherModel);
                    break;
                case 1:
                    TeacherModel teacherModel=materialService.findTeacherById(model.getRecordId());
                    model.setName(teacherModel.getName());
                    pair=Pair.of(model,teacherModel);
                    break;
                case 2:
                    ItemModel itemModel=materialService.findItemById(model.getRecordId());
                    model.setName(itemModel.getName());
                    pair=Pair.of(model,itemModel);
                    break;
                case 3:
                    PaperModel paperModel=materialService.findPaperById(model.getRecordId());
                    model.setName(paperModel.getTitle());
                    pair=Pair.of(model,paperModel);
                    break;
                default:
                    pair=Pair.of(model,"error");
            }
            pairs.add(pair);
        }
    }



}
