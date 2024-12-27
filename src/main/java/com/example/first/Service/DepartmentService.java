package com.example.first.Service;

import com.example.first.Entities.Department;
import com.example.first.Entities.Employee;
import com.example.first.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department createDepartment(Department dep){
        return departmentRepo.save(dep);
    }

    public List<Department> findAllDepartment(){
        return departmentRepo.findAll();
    }

    public Optional<Department> findByDepartment(Long id){
        return departmentRepo.findById(id);

    }
}
