package com.olujobii.service.impl;

import com.olujobii.model.baseClass.Staff;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final DepartmentRepository departmentRepository;

    public StaffServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Staff> listAllStaffs(){
        return departmentRepository.getTotalStaffs();
    }
}
