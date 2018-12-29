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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
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
    public List<RecordModel> showAdminMaterial(){
        List<RecordModel> recordModels=materialService.findAllRecord();
        setName(recordModels);
        return recordModels;
    }

    /**
     *
     * @return 一组Pair{first:RecordModel,second:OtherModel/TeacherModel/ItemModel/PaperModel}
     */
    @RequestMapping(value = "teacher/show",method = RequestMethod.GET)
    @ResponseBody
    public List<RecordModel> showTeacherMaterial(@RequestParam int id){
        List<RecordModel> recordModels=materialService.findByUserId(id);
        setName(recordModels);
        return recordModels;
    }

    private void setName(List<RecordModel> list) {
        for(RecordModel model:list){
            switch (model.getType()){
                case 0:
                    OtherModel otherModel=materialService.findOtherById(model.getRecordId());
                    model.setName(otherModel.getPointModel().getContent());
                    model.setStatus(otherModel.getStatus());
                    break;
                case 1:
                    TeacherModel teacherModel=materialService.findTeacherById(model.getRecordId());
                    model.setName(teacherModel.getName());
                    break;
                case 2:
                    ItemModel itemModel=materialService.findItemById(model.getRecordId());
                    model.setName(itemModel.getName());
                    model.setStatus(itemModel.getStatus());
                    break;
                case 3:
                    PaperModel paperModel=materialService.findPaperById(model.getRecordId());
                    model.setName(paperModel.getTitle());
                    model.setStatus(paperModel.getStatus());
                    break;
                default:
                    model.setName("unknown");
            }
        }
    }

    @RequestMapping(value = "specific/show",method = RequestMethod.GET)
    @ResponseBody
    public Object showSpecificMaterial(RecordModel model){
        switch (model.getType()){
            case 0:
                return materialService.findOtherById(model.getRecordId());
            case 1:
                return materialService.findTeacherById(model.getRecordId());
            case 2:
                return materialService.findItemById(model.getRecordId());
            case 3:
                return materialService.findPaperById(model.getRecordId());
            default:
                return "error:wrong type";
        }
    }

    /**
     *上传或修改Other表单数据
     * @param recordModel 如果是修改则会有id
     * @param otherModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/0/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public String uploadOtherMaterial(@PathVariable int userId, RecordModel recordModel,
                                      OtherModel otherModel, MultipartFile file) throws IOException {
        String basePath = "src/main/webapp/static/resources/others/";
        try {
            String src=uploadFile(basePath,file);
            otherModel.setSrc(src);
            otherModel.setStatus(0);
            int otherId=materialService.saveOther(otherModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,0,otherId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    /**
     *上传或修改Teacher表单数据
     * @param recordModel 如果是修改则会有id
     * @param teacherModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/1/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public String uploadTeacherMaterial(@PathVariable int userId,RecordModel recordModel,
                                        TeacherModel teacherModel,MultipartFile file) throws IOException {
        String basePath = "src/main/webapp/resources/teachers/";
        try {
            String src=uploadFile(basePath,file);
            teacherModel.setSrc(src);
            teacherModel.setStatus(0);
            int teacherId=materialService.saveTeacher(teacherModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,0,teacherId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    /**
     *上传或修改Item表单数据
     * @param recordModel 如果是修改则会有id
     * @param itemModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/2/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public String uploadItemMaterial(@PathVariable int userId,RecordModel recordModel,
                                     ItemModel itemModel,MultipartFile file) throws IOException {
        String basePath = "src/main/webapp/resources/items/";
        try {
            String src=uploadFile(basePath,file);
            itemModel.setSrc(src);
            itemModel.setStatus(0);
            int itemId=materialService.saveItem(itemModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,0,itemId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    /**
     *上传或修改Paper表单数据
     * @param recordModel 如果是修改则会有id
     * @param paperModel 表单数据
     * @param file 上传文件
     * @return 成功返回1
     * @throws IOException
     */
    @RequestMapping(value = "teacher/upload/3/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public String uploadPaperMaterial(@PathVariable int userId,RecordModel recordModel,
                                      PaperModel paperModel,MultipartFile file) throws IOException {
        String basePath = "src/main/webapp/resources/papers/";
        try {
            String src=uploadFile(basePath,file);
            paperModel.setSrc(src);
            paperModel.setStatus(0);
            int paperId=materialService.savePaper(paperModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,0,paperId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
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
        try {
            materialService.updateStatus(model.getRecordId(),model.getType(),status[0]);
            materialService.updateContent(model.getType(),model.getRecordId());
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
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
        String abs="D:\\IdeaProjects\\scm\\";
        String year = calendar.get(Calendar.YEAR) + "";
        String month = calendar.get(Calendar.MONTH) + "";
        String uploadTargetPath = basePath + year + month + "/";

        String originalFileName = file.getOriginalFilename();
        String fileType = originalFileName.substring(originalFileName.indexOf(".") + 1);
        String newFileName = UUID.randomUUID().toString() + "." + fileType;
        File targetFile = new File(uploadTargetPath, newFileName);
        File parent=new File(abs+targetFile.getParent());
        if(!parent.exists()) {
            parent.mkdirs();
        }
        file.transferTo(targetFile);
        return uploadTargetPath.substring(uploadTargetPath.indexOf("resources"))+newFileName;
    }
}
