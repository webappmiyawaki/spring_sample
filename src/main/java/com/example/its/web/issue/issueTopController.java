package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/issuesTop")
@Controller
public class issueTopController {

    private final IssueService issueService;

    //GET /issues
    @GetMapping("")
    public String showList(Model model){

        model.addAttribute("issueList",issueService.findAll());
        return "issues/list";
    }
}
