package com.mario.pe.restservicedata.sevices;

import com.mario.pe.restservicedata.entity.Department;
import com.mario.pe.restservicedata.entity.Person;
import com.mario.pe.restservicedata.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public Department getDepartment(long id){
        return departmentRepository.findOne(id);
    }

    public void addDepartment(Department department){
        long id = department.getId();
        String name = department.getName();
        System.out.println("id: " + id + " name: " + name);
        departmentRepository.save(department);
    }

    public void updateDepartment(Department department){
        departmentRepository.save(department);
    }

    public void deleteDepartment(long id){
        departmentRepository.delete(id);
    }

}
