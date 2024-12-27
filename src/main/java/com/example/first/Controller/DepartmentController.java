package com.example.first.Controller;

import com.example.first.Entities.Department;
import com.example.first.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abc/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department department1 = departmentService.createDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAll(){
        List<Department> departmentList = departmentService.findAllDepartment();
        if(departmentList!=null){
            return new ResponseEntity<>(departmentList,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id){
        return departmentService.findByDepartment(id).map((dep)->new ResponseEntity<>(dep,HttpStatus.OK)).
                orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
