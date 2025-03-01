package com.app.EmployeePayRoll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 3000, message = "Minimum salary should be 3000")
    private double salary;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start date is required")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date must be a past or present date")
    private LocalDate startDate;

    private String note;

    @NotBlank(message = "Profile picture URL cannot be empty")
    private String profilePic;

    @NotBlank(message = "At least one department must be selected")
    private String department;
}
