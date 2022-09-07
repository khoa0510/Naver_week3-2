package com.example.naver_week32.service.impl;

import com.example.naver_week32.dto.DepartmentDto;
import com.example.naver_week32.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    public DepartmentDto getDepartmentDto(DepartmentDto departmentDto){
        logger.info("Đối số truyền vào: " + departmentDto.toString());
        return departmentDto;
    }
}
