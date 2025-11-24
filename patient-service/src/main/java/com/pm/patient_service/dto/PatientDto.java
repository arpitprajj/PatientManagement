package com.pm.patient_service.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientDto {
    private String id;
    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min=3,max=100 ,message = "name should be between 3 to 100 char")
    private String name;
    @NotNull
    @NotBlank(message = "email cannot be Blank")
    private String email;
    @NotNull
    @NotBlank(message = "Address should not be blank")
    private String address;

    @NotNull(message = "DOB should not be null")
    private LocalDate dob;
}
