package com.mario.pe.restservicedata.repository;


import com.mario.pe.restservicedata.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    public List<Person> findByDepartmentId(long departmentId);
}
