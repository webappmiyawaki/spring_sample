package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/issuesDelete")
@Controller
public class issueDeleteController {

    private final IssueService issueService;



    @GetMapping("/deleteForm")
    public String showDeleteForm(@ModelAttribute DeleteForm form){
        //model.addAttribute("issueForm",new IssueForm());が略される＝@ModelAttribute
        return "issues/deleteForm";
    }

    @PostMapping("delete_method")
    public String delete(@Validated DeleteForm form, BindingResult bindingResult, Model model) {
        issueService.delete(form.getId());
        return "redirect:/issuesTop";
    }

}
