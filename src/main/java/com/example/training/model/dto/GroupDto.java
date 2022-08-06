package com.example.training.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GroupDto {

    @NotBlank(message = "FistName cannot be blank")
    private String groupName;

    @NotNull(message = "Group must have an instructor")
    private long instructorId;


}
