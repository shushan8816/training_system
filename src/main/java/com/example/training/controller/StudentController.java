package com.example.training.controller;

import com.example.training.model.dao.SportGroup;
import com.example.training.model.dao.Students;
import com.example.training.model.dto.GroupAttachmentDto;
import com.example.training.model.dto.StudentDto;
import com.example.training.service.interfaces.StudentService;
import com.example.training.utill.exceptions.BadRequestException;
import com.example.training.utill.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity addStudents(@RequestBody StudentDto students) {
        studentService.addStudents(students);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> groups = studentService.getAllStudents();
        return ResponseEntity.ok(groups);
    }

    @PostMapping("/attach-to-group")
    public ResponseEntity<Void> attachToGroup(@RequestBody GroupAttachmentDto groupAttachmentDto) throws BadRequestException, NotFoundException {
        studentService.attachToGroup(groupAttachmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }
}
