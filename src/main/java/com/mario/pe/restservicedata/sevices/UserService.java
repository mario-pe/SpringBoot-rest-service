package com.mario.pe.restservicedata.sevices;


import com.mario.pe.restservicedata.entity.Person;
import com.mario.pe.restservicedata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons(){
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return people;
    }

    public List<Person> getAllPersonsInDepartment(long departmentId){
        List<Person> people = new ArrayList<>();
        personRepository.findByDepartmentId(departmentId)
                .forEach(people::add);
        return people;
    }

    public Person getPerson(long id){
        return personRepository.findOne(id);
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public void updatePerson(Person person){
        personRepository.save(person);
    }

    public void deletePerson(long id){
        personRepository.delete(id);
    }

}
