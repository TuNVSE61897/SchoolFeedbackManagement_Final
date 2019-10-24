package com.sample.sfms.service.impl;

import com.sample.sfms.entity.Department;
import com.sample.sfms.repository.DepartmentRepository;
import com.sample.sfms.service.interf.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
