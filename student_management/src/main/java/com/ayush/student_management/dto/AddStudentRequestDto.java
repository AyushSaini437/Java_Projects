package com.ayush.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddStudentRequestDto {

    @NotBlank(message = "Field is required")
    @Size(min = 3, max = 30, message = "Should be 3-30 characters long")
    private String name;

    @Email
    @NotBlank(message = "Field is required")
    private String email;
}
