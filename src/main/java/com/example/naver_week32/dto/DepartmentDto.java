package com.example.naver_week32.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DepartmentDto {
    private Long departmentId;
    @NotEmpty(message = "Thiếu tên")
    @Size(min = 10, max = 50, message = "Tên phòng ban phải nằm trong khoảng 10 đến 50 ký tự")
    private String name;
    @NotEmpty(message = "Miêu tả không được rỗng")
    private String description;
    private List<@Valid EmployeeDto> employeeDtoList;
}
