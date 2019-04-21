package com.lzc.teachingInteraction.controller.admin;


import com.lzc.teachingInteraction.entity.Material;

import com.lzc.teachingInteraction.service.MaterialService;
import com.lzc.teachingInteraction.service.TeacherService;
import com.lzc.teachingInteraction.service.UserService;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.utils.FileUtils;
import com.lzc.teachingInteraction.vo.MaterialVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程方面的管理
 */
@Controller
public class AdminMaterialController {
     @Autowired
     MaterialService materialService;
     @Autowired
    TeacherService teacherService;
     @Autowired
    UserService userService;
    /**
     * 课程列表
     * @param model
     * @return
     */
    @RequestMapping("admin-material-list.html")
    public String MaterialList(Model model,String cId){
        System.out.println(cId);
        List<MaterialVo> MaterialVos = materialService.selectAllVoByCId(cId);
        model.addAttribute("MaterialVos",MaterialVos);
        model.addAttribute("commons",new Commons());
        model.addAttribute("cId",cId);
        return "admin/Material/list";
    }

    /**
     * 资料修改页面跳转
     * @param model
     * @param mId
     * @return
     */
    @RequestMapping("admin-material-update.html")
    public String MaterialUpdateUi(Model model,String mId){
        System.out.println("mid:"+mId);
        Material Material = materialService.selectById(mId);
        model.addAttribute("material",Material);
        model.addAttribute("commons",new Commons());
        return  "admin/Material/update";
    }

    /**
     * 更新的实现
     * @param material
     * @param req
     * @param multiReq
     * @return
     */
    @RequestMapping("admin-material-update")
    @ResponseBody
    public String MaterialUpdate(Material material, HttpServletRequest req,
                               MultipartHttpServletRequest multiReq){
        String url = FileUtils.UploadFile(req, multiReq);
        System.out.println(url);

        String typeUrl = url.substring(url.lastIndexOf(".") + 1, url.length());
        System.out.println("type："+typeUrl);
        material.setmType(typeUrl);
        material.setUrl(url);
        materialService.update(material);
        return "success";
    }

    /**
     * 删除
     * @param mId
     * @return
     */
    @RequestMapping("admin-material-del")
    @ResponseBody
    public String MaterialDel(String mId){
        materialService.del(mId);
        return "success";
    }

    /**
     * 跳转到增加资料的页面
     * @param cId
     * @param model
     * @return
     */
   @RequestMapping("admin-material-add.html")
    public String materialAddUi(String cId,Model model){
       System.out.println("cid:"+cId);
        model.addAttribute("cId",cId);
        return "admin/material/add";
   }

    /**
     * 添加的实现
     * @param material
     * @param req
     * @param multiReq
     * @return
     */
   @RequestMapping("admin-material-add")
   @ResponseBody
    public String materialAdd(Material material,
                              String cId,
                              HttpServletRequest req,
                              MultipartHttpServletRequest multiReq){
       String url = FileUtils.UploadFile(req, multiReq);
       System.out.println(url);
       String typeUrl = url.substring(url.lastIndexOf(".") + 1, url.length());
       material.setmType(typeUrl);
       material.setUrl(url);
       materialService.add(material);
       return "success";
   }
}
