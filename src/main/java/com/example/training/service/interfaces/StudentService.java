package com.example.training.service.interfaces;

import com.example.training.model.dao.SportGroup;
import com.example.training.model.dao.Students;
import com.example.training.model.dto.GroupAttachmentDto;
import com.example.training.model.dto.StudentDto;
import com.example.training.utill.exceptions.BadRequestException;
import com.example.training.utill.exceptions.NotFoundException;

import java.util.List;

public interface StudentService {
    void addStudents(StudentDto student);

    List<Students> getAllStudents();

    void attachToGroup(GroupAttachmentDto groupAttachmentDto) throws BadRequestException, NotFoundException;

    void removeStudent(Long id);
}
