package com.scm.controller;


/*
管理员查看材料提交  /scm/material/admin/show
管理员审核材料提交 /scm/material/admin/check
教师材料的提交上传或修改 /scm/material/teachers/upload/{}
教师材料提交记录的查看 /scm/material/teachers/show
 */

import com.scm.model.*;
import com.scm.pageModel.ItemPageModel;
import com.scm.pageModel.PaperPageModel;
import com.scm.pageModel.RecordPageModel;
import com.scm.pageModel.TeacherPageModel;
import com.scm.service.MaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
        import java.io.File;
        import java.io.IOException;
import java.util.ArrayList;
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
    public List<RecordPageModel> showAdminMaterial(){
        List<RecordModel> recordModels=materialService.findAllRecord();
        setName(recordModels);
        return convertRecordPageModel(recordModels);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "teacher/show",method = RequestMethod.GET)
    @ResponseBody
    public List<RecordPageModel> showTeacherMaterial(@RequestParam int id){
        List<RecordModel> recordModels=materialService.findByUserId(id);
        setName(recordModels);
        return convertRecordPageModel(recordModels);
    }

    @RequestMapping(value = "specific/show/{type}/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object showSpecificMaterial(@PathVariable int type,@PathVariable int id){
        try {
            switch (type){
                case 0:
                    return materialService.findOtherById(id);
                case 1:
                    TeacherModel teacherModel=materialService.findTeacherById(id);
                    return convertTeacherPageModel(teacherModel);
                case 2:
                    ItemModel itemModel= materialService.findItemById(id);
                    return convertItemPageModel(itemModel);
                case 3:
                    PaperModel paperModel= materialService.findPaperById(id);
                    return converPaperPageModel(paperModel);
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

    private PaperPageModel converPaperPageModel(PaperModel paperModel) {
        PaperPageModel paperPageModel=new PaperPageModel();
        BeanUtils.copyProperties(paperModel,paperPageModel);
        switch (paperModel.getFirstType()){
            case 0:
                paperPageModel.setPaperType("本科生");
                break;
            case 1:
                paperPageModel.setPaperType("研究生");
                break;
            case 2:
                paperPageModel.setPaperType("教师");
                break;
        }
        switch (paperModel.getPaperType()){
            case 0:
                paperPageModel.setPaperType("核心期刊（浙大标准）");
                break;
            case 1:
                paperPageModel.setPaperType("国内权威期刊论文数");
                break;
            case 2:
                paperPageModel.setPaperType("SCI top收录期刊论文");
                break;
            case 3:
                paperPageModel.setPaperType("其他");
                break;
        }
        return paperPageModel;
    }

    private ItemPageModel convertItemPageModel(ItemModel itemModel) {
        ItemPageModel itemPageModel=new ItemPageModel();
        BeanUtils.copyProperties(itemModel,itemPageModel);
        switch (itemModel.getType()){
            case 1:
                itemPageModel.setType("团队");
                break;
            case 2:
                itemPageModel.setType("科研创新平台");
                break;
            case 3:
                itemPageModel.setType("产学研平台");
                break;
            case 4:
                itemPageModel.setType("教学成果");
                break;
            case 5:
                itemPageModel.setType("精品课程、视频公开课");
                break;
            case 6:
                itemPageModel.setType("规划教材");
                break;
            case 7:
                itemPageModel.setType("学科竞赛");
                break;
            case 8:
                itemPageModel.setType("科研项目");
                break;
            case 9:
                itemPageModel.setType("出版著作");
                break;
            case 10:
                itemPageModel.setType("授权发明专利");
                break;
            case 11:
                itemPageModel.setType("成果奖励");
                break;
            case 12:
                itemPageModel.setType("横向课题项目");
                break;
            case 13:
                itemPageModel.setType("国际科研合作项目");
                break;
        }
        switch (itemModel.getIsImportant()){
            case 1:
                itemPageModel.setIsImportant("是");
                break;
            case 0:
                itemPageModel.setIsImportant("否");
                break;
        }
        switch (itemModel.getRank()){
            case 0:
                itemPageModel.setRank("国家级");
                break;
            case 1:
                itemPageModel.setRank("省部级");
                break;
            case 2:
                itemPageModel.setRank("其他");
                break;
        }
        return itemPageModel;
    }

    private TeacherPageModel convertTeacherPageModel(TeacherModel teacherModel) {
        TeacherPageModel teacherPageModel=new TeacherPageModel();
        BeanUtils.copyProperties(teacherModel,teacherPageModel);
        switch (teacherModel.getEdu()){
            case 0:
                teacherPageModel.setEdu("博士");
                break;
            case 1:
                teacherPageModel.setEdu("硕士");
                break;
            case 2:
                teacherPageModel.setEdu("本科");
                break;
        }
        switch (teacherModel.getIsImportant()){
            case 1:
                teacherPageModel.setIsImportant("是");
                break;
            case 0:
                teacherPageModel.setIsImportant("否");
                break;
        }
        switch (teacherModel.getRank()){
            case 0:
                teacherPageModel.setRank("国家级");
                break;
            case 1:
                teacherPageModel.setRank("省部级");
                break;
            case 2:
                teacherPageModel.setRank("其他");
                break;
        }
        return teacherPageModel;
    }

    private List<RecordPageModel> convertRecordPageModel(List<RecordModel> recordModels) {
        List<RecordPageModel> pageModels=new ArrayList<>();
        for(RecordModel model:recordModels){
            RecordPageModel pageModel=new RecordPageModel();
            BeanUtils.copyProperties(recordModels,pageModel);
            switch (model.getStatus()){
                case 0:
                    pageModel.setStatus("待审核");
                    break;
                case -1:
                    pageModel.setStatus("未通过");
                    break;
                case 1:
                    pageModel.setStatus("已通过");
                    break;
            }
            pageModels.add(pageModel);
        }
        return pageModels;
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
}
