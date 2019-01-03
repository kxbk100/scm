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

import javax.servlet.http.HttpServletRequest;
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
     * @return
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
     * @return
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

    @RequestMapping(value = "specific/show/{type}/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object showSpecificMaterial(@PathVariable int type,@PathVariable int id){
        try {
            switch (type){
                case 0:
                    return materialService.findOtherById(id);
                case 1:
                    return materialService.findTeacherById(id);
                case 2:
                    return materialService.findItemById(id);
                case 3:
                    return materialService.findPaperById(id);
                default:
                    return "error:wrong type";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "0";
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
                                      OtherModel otherModel, MultipartFile file, HttpServletRequest request) throws IOException {
        String basePath = request.getSession().getServletContext().getRealPath("/") + "others/";
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
                                        TeacherModel teacherModel,MultipartFile file,HttpServletRequest request) throws IOException {
        String basePath = request.getSession().getServletContext().getRealPath("/") + "teachers/";
        try {
            String src=uploadFile(basePath,file);
            teacherModel.setSrc(src);
            teacherModel.setStatus(0);
            int teacherId=materialService.saveTeacher(teacherModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,1,teacherId);
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
                                     ItemModel itemModel,MultipartFile file,HttpServletRequest request) throws IOException {
        String basePath = request.getSession().getServletContext().getRealPath("/") + "items/";
        try {
            String src=uploadFile(basePath,file);
            itemModel.setSrc(src);
            itemModel.setStatus(0);
            int itemId=materialService.saveItem(itemModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,2,itemId);
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
                                      PaperModel paperModel,MultipartFile file,HttpServletRequest request) throws IOException {
        String basePath = request.getSession().getServletContext().getRealPath("/") + "papers/";
        try {
            String src=uploadFile(basePath,file);
            paperModel.setSrc(src);
            paperModel.setStatus(0);
            int paperId=materialService.savePaper(paperModel);
            if(recordModel.getId()!=0){
                materialService.updateRecordDate(recordModel.getId());
            }else{
                materialService.saveRecord(userId,3,paperId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    /**
     * 管理员审核提交
     * @param status
     * @return 成功返回1
     */
    @RequestMapping(value = "admin/check",method = RequestMethod.GET)
    @ResponseBody
    public String checkAdminMaterial(@RequestParam int recordId,@RequestParam int type,@RequestParam int status){
        try {
            materialService.updateStatus(recordId,type,status);
            if(status==1){
                materialService.updateContent(type,recordId);
            }
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
        String year = calendar.get(Calendar.YEAR) + "";
        String month = calendar.get(Calendar.MONTH) + "";
        String uploadTargetPath = basePath + year + month + "/";

        String originalFileName = file.getOriginalFilename();
        String fileType = originalFileName.substring(originalFileName.indexOf(".") + 1);
        String newFileName = UUID.randomUUID().toString() + "." + fileType;
        File targetFile = new File(uploadTargetPath, newFileName);
        File parent=new File(targetFile.getParent());
        if(!parent.exists()) {
            parent.mkdirs();
        }
        file.transferTo(targetFile);
        return targetFile.getAbsolutePath();
    }
}
