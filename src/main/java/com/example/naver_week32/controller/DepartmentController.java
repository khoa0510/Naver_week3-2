package com.example.naver_week32.controller;

import com.example.naver_week32.dto.DepartmentDto;
import com.example.naver_week32.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/getDepartment")
    public ResponseEntity<DepartmentDto> getDepartmentDto(@RequestBody @Valid DepartmentDto departmentDto)
    {
        return ResponseEntity.ok(departmentService.getDepartmentDto(departmentDto));
    }
}
