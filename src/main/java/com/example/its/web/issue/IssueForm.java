package com.example.its.web.issue;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class IssueForm {
    @NotBlank
    @Size(max=256)
    private String id;

    @Size(max=256)
    private String summary;

    @Size(max=256)
    private String description;
}
