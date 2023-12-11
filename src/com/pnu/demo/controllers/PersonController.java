package com.pnu.demo.controllers;


import com.pnu.demo.entities.Person;
import com.pnu.demo.services.PersonService;
import edu.pnu.myspring.annotations.MyAutowired;
import edu.pnu.myspring.annotations.MyRestController;

@MyRestController
public class PersonController {
    @MyAutowired
    private PersonService service;

    public PersonController() {
    }

    public void createPerson(String name, int age) {
        service.save(name, age);
    }

    public Person getPerson(Long id) {
        return service.findById(id);
    }
}


