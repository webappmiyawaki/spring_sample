package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/issuesCreate")
@Controller
public class issueCreateController {

    private final IssueService issueService;

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        //model.addAttribute("issueForm",new IssueForm());が略される＝@ModelAttribute
        return "issues/creationForm";
    }

    @PostMapping("create_method")
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        issueService.create(form.getId(),form.getSummary(),form.getDescription());
        return "redirect:/issuesTop";
    }

    @GetMapping("{issueId}")
    public String showDetail(@PathVariable("issueId") String issueId,Model model){
        model.addAttribute("issue",issueService.findById(issueId));
        return "issues/detail";
    }
}
