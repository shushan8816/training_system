package com.example.training.service.implementations;

import com.example.training.model.dao.Instructors;
import com.example.training.repository.GroupRepository;
import com.example.training.repository.InstructorRepository;
import com.example.training.service.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {


    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    GroupRepository groupRepository;


    @Override
    public void add(Instructors instructors) {
        instructorRepository.save(instructors);
    }
}
