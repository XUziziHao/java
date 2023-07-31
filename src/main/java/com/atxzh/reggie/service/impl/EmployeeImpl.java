package com.atxzh.reggie.service.impl;


import com.atxzh.reggie.entity.Employee;
import com.atxzh.reggie.mapper.EmployeeMapper;
import com.atxzh.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
