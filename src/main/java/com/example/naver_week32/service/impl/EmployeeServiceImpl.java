package com.example.naver_week32.service.impl;

import com.example.naver_week32.dto.EmployeeDto;
import com.example.naver_week32.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    public EmployeeDto getEmployeeDto(EmployeeDto employeeDto){
        logger.info("Đối số truyền vào: " + employeeDto.toString());
        return employeeDto;
    }
}
