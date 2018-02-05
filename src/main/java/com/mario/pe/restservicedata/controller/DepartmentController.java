package com.mario.pe.restservicedata.controller;

import com.mario.pe.restservicedata.entity.Department;
import com.mario.pe.restservicedata.sevices.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department")
    public List<Department> getAllUsers(){
        return departmentService.getAllDepartments();
    }

    @RequestMapping("department/{id}")
    public Department getUser(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/department")
    public void addDepartment(@RequestBody Department department){
        long id = department.getId();
        String name = department.getName();
        System.out.println("id: " + id + " name: " + name);
        departmentService.addDepartment(department);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/department")
    public void updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/department/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }
}
