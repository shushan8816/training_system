package com.example.training.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentDto {

    @NotBlank(message = "FistName cannot be blank")
    private String firstName;

    @NotBlank(message = "LastName cannot be blank")
    private String lastName;

}
