package com.mario.pe.restservicedata.controller;


import com.mario.pe.restservicedata.entity.Department;
import com.mario.pe.restservicedata.entity.Person;
import com.mario.pe.restservicedata.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public List<Person> getAllUsers(){
        return userService.getAllPersons();
    }

    @RequestMapping(value = "/users/in/dept/{deptId}")
    public List<Person> getAllPersonsInDepartment(@PathVariable long deptId){
        return userService.getAllPersonsInDepartment(deptId);
    }

    @RequestMapping("user/{id}")
    public Person getUser(@PathVariable Long id){
        return userService.getPerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody Person person){
        userService.addPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{deptId}")
    public void updateUser(@RequestBody Person person, @PathVariable long deptId){
        System.out.println(deptId);
        person.setDepartment(new Department(deptId,""));
        userService.updatePerson(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deletePerson(@PathVariable Long id){
        userService.deletePerson(id);
    }
}
