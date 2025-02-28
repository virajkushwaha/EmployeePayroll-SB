package com.app.EmployeePayRoll.dto;

import com.app.EmployeePayRoll.model.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
public  class EmployeeDTO {

    @NotBlank(message = "Name Cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name ;

    private String department ;
    private double salary;

}
