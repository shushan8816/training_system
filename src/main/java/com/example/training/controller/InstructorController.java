package com.example.training.controller;

import com.example.training.model.dao.Instructors;
import com.example.training.service.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping
    public ResponseEntity addInstructor(@RequestBody Instructors instructors) {
        instructorService.add(instructors);
        return ResponseEntity.ok().build();
    }


}
