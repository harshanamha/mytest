package com.example.first.Service;

import com.example.first.Entities.Employee;
import com.example.first.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public Employee createUser(Employee emp){
       return employeeRepo.save(emp);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> findByEmployee(Long id){
        return employeeRepo.findById(id);

    }
    public  Employee UpdateEmployee(Long id,Employee emp){
        Optional<Employee> em = employeeRepo.findById(id);
        if(em.isPresent()){
            Employee employee = em.get();
            employee.setEpfNo(emp.getEpfNo());
            employee.setFullName(emp.getFullName());
            employee.setEmail(emp.getEmail());
            employee.setDob(emp.getDob());
            employee.setDesignation(emp.getDesignation());
            employee.setDep(emp.getDep());
            employee.setAddress(emp.getAddress());
            employee.setNic(emp.getNic());
            employee.setMobile(emp.getMobile());

           return employeeRepo.save(employee);
        }
        return null;
    }

    public boolean deleteUser(Long id){
        Optional<Employee> emp = employeeRepo.findById(id);
        if (emp.isPresent()){
            employeeRepo.delete(emp.get());
            return true;
        }

        return false;
    }
}
