package com.example.expense_tracker.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    @NotBlank
    private String Username;

    @NotBlank
    @Email
    private String Email;

    @NotBlank
    private String Password;

    @NotBlank
    private String ConfirmPassword;

}
