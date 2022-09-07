package com.example.naver_week32.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class EmployeeDto {
    private Long employeeId;
    @NotEmpty(message = "Thiếu tên")
    @Size(min = 10, max = 50, message = "Tên nhân viên phải nằm trong khoảng 10 đến 50 ký tự")
    private String name;
    private Date birthDate;
    private String gender;
    @NotEmpty(message = "Thiếu email")
    @Email(message = "Sai định dạng email")
    private String email;
}
