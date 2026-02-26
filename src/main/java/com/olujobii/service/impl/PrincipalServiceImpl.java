package com.olujobii.service.impl;

import com.olujobii.model.Principal;
import com.olujobii.model.baseClass.Staff;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.PrincipalService;

import java.util.List;

public class PrincipalServiceImpl implements PrincipalService {
    private final DepartmentRepository departmentRepository;

    public PrincipalServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Principal getPrincipal(){
        List<Staff> staffs = departmentRepository.getTotalStaffs();

        for(Staff staff : staffs){
            if(staff instanceof Principal principal)
                return principal;
        }

        return null;
    }
}
