package com.scm.controller;


/*
管理员查看材料提交  /scm/material/admin/show
管理员审核材料提交 /scm/material/admin/check
教师材料的提交上传或修改 /scm/material/teachers/upload/{}
教师材料提交记录的查看 /scm/material/teachers/show
 */

import com.scm.model.*;
import com.scm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


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

    /**
     *
     * @param session 从session中拿当前User
     * @return 一组Pair{first:RecordModel,second:OtherModel/TeacherModel/ItemModel/PaperModel}
     */
    @RequestMapping(value = "teacher/show",method = RequestMethod.GET)
    @ResponseBody
    public List<Pair<RecordModel,?>> showTeacherMaterial(HttpSession session){
        List<Pair<RecordModel,?>> pairs=new ArrayList<>();
        UserModel userModel=(UserModel) session.getAttribute("user");
        List<RecordModel> recordModels=materialService.findByUserId(userModel.getId());
        preparePairList(recordModels,pairs);
        return pairs;
    }

    /**
     *上传或修改Other表单数据
     * @param session 用来获取userId
     * @param recordModel 如果是修改则会有id
     * @param otherModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/0",method = RequestMethod.POST)
    @ResponseBody
    public String uploadOtherMaterial(HttpSession session,RecordModel recordModel,
                                      OtherModel otherModel, MultipartFile file) throws IOException {
        UserModel userModel=(UserModel) session.getAttribute("user");
        String basePath = "src/main/webapp/resources/others/";
        String src=uploadFile(basePath,file);
        otherModel.setSrc(src);
        otherModel.setStatus(0);
        int id=materialService.saveOther(otherModel);
        if(recordModel.getId()!=0){
            materialService.updateRecordDate(recordModel.getId());
        }else{
            materialService.saveRecord(userModel.getId(),0,id);
        }
        return "1";
    }

    /**
     *上传或修改Teacher表单数据
     * @param session 用来获取userId
     * @param recordModel 如果是修改则会有id
     * @param teacherModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/1",method = RequestMethod.POST)
    @ResponseBody
    public String uploadTeacherMaterial(HttpSession session,RecordModel recordModel,
                                        TeacherModel teacherModel,MultipartFile file) throws IOException {
        UserModel userModel=(UserModel) session.getAttribute("user");
        String basePath = "src/main/webapp/resources/teachers/";
        String src=uploadFile(basePath,file);
        teacherModel.setSrc(src);
        teacherModel.setStatus(0);
        int id=materialService.saveTeacher(teacherModel);
        if(recordModel.getId()!=0){
            materialService.updateRecordDate(recordModel.getId());
        }else{
            materialService.saveRecord(userModel.getId(),0,id);
        }
        return "1";
    }

    /**
     *上传或修改Item表单数据
     * @param session 用来获取userId
     * @param recordModel 如果是修改则会有id
     * @param itemModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/2",method = RequestMethod.POST)
    @ResponseBody
    public String uploadItemMaterial(HttpSession session,RecordModel recordModel,
                                     ItemModel itemModel,MultipartFile file) throws IOException {
        UserModel userModel=(UserModel) session.getAttribute("user");
        String basePath = "src/main/webapp/resources/items/";
        String src=uploadFile(basePath,file);
        itemModel.setSrc(src);
        itemModel.setStatus(0);
        int id=materialService.saveItem(itemModel);
        if(recordModel.getId()!=0){
            materialService.updateRecordDate(recordModel.getId());
        }else{
            materialService.saveRecord(userModel.getId(),0,id);
        }
        return "1";
    }

    /**
     *上传或修改Paper表单数据
     * @param session 用来获取userId
     * @param recordModel 如果是修改则会有id
     * @param paperModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/3",method = RequestMethod.POST)
    @ResponseBody
    public String uploadPaperMaterial(HttpSession session,RecordModel recordModel,
                                      PaperModel paperModel,MultipartFile file) throws IOException {
        UserModel userModel=(UserModel) session.getAttribute("user");
        String basePath = "src/main/webapp/resources/papers/";
        String src=uploadFile(basePath,file);
        paperModel.setSrc(src);
        paperModel.setStatus(0);
        int id=materialService.savePaper(paperModel);
        if(recordModel.getId()!=0){
            materialService.updateRecordDate(recordModel.getId());
        }else{
            materialService.saveRecord(userModel.getId(),0,id);
        }
        return "1";
    }

    /**
     * 管理员审核提交
     * @param model
     * @param status
     * @return 成功返回1
     */
    @RequestMapping(value = "admin/check",method = RequestMethod.POST)
    @ResponseBody
    public String checkAdminMaterial(RecordModel model,int[] status){
        materialService.updateStatus(model.getRecordId(),model.getType(),status[0]);
        return "1";
    }

    /**
     * 将上传的文件保存在本地
     * @param basePath
     * @param file
     * @return 文件的相对路径
     * @throws IOException
     */
    private String uploadFile(String basePath,MultipartFile file) throws IOException {
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = calendar.get(Calendar.MONTH) + "";
        String uploadTargetPath = basePath + year + month + "/";

        String originalFileName = file.getOriginalFilename();
        String fileType = originalFileName.substring(originalFileName.indexOf(".") + 1);
        String newFileName = UUID.randomUUID().toString() + "." + fileType;
        File targetFile = new File(uploadTargetPath, newFileName);

        if(!targetFile.exists()) {
            new File(uploadTargetPath).mkdirs();
        }
        file.transferTo(targetFile);
        return uploadTargetPath.substring(uploadTargetPath.indexOf("resources"))+newFileName;
    }

    /**
     * 将提交记录和对应的表单数据组成Pair对，添加进列表中返回
     * @param recordModels
     * @param pairs
     */
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
