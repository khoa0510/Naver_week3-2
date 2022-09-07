package com.example.naver_week32.controller;

import com.example.naver_week32.dto.EmployeeDto;
import com.example.naver_week32.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/getEmployee")
    public ResponseEntity<EmployeeDto> getEmployee(@RequestBody @Valid EmployeeDto employeeDto,
                                                   BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            throw new RuntimeException("Bad Request");
        }
        return ResponseEntity.ok(employeeService.getEmployeeDto(employeeDto));
    }
}
