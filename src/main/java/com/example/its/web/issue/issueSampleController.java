package com.example.its.web.issue;

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

@RequiredArgsConstructor
@RequestMapping("/issuesSample")
@Controller
public class issueSampleController {

    private final IssueService issueService;

    //GET /issues
    @GetMapping("")
    public String showList(Model model){

        model.addAttribute("issueList",issueService.findAll());
        return "issues/list";
    }

    //一覧画面の表示
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        //model.addAttribute("issueForm",new IssueForm());が略される＝@ModelAttribute
         return "issues/creationForm";
    }

    //新規入力データの保存
    @PostMapping("create_method")
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        issueService.create(form.getId(),form.getSummary(),form.getDescription());
        return "redirect:/issuesTop";
    }

}
