package com.lzc.teachingInteraction.controller.admin;

import com.lzc.teachingInteraction.service.EvaluateService;
import com.lzc.teachingInteraction.utils.Commons;
import com.lzc.teachingInteraction.vo.EvaluateVo;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminEvaluateController {
    @Autowired
    EvaluateService evaluateService;

    /**
     * 评论列表
     * @param model
     * @return
     */
    @RequestMapping("admin-evaluate-list.html")
    public String evaluateList(Model model){
        List<EvaluateVo> evaluateVos = evaluateService.selectAll();
        model.addAttribute("evs",evaluateVos);
        model.addAttribute("commons",new Commons());
        return "admin/evaluate/list";
    }

    @RequestMapping("admin-evaluate-del")
    @ResponseBody
    public String evaluateDel(String eId){
        evaluateService.del(eId);
        return "success";
    }
}
