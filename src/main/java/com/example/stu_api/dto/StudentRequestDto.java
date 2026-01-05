package com.example.stu_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Min(1)
    private int age;
}
