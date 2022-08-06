package com.example.training.service.implementations;

import com.example.training.model.SportGroupStudents;
import com.example.training.model.GroupStudentsId;
import com.example.training.model.dao.SportGroup;
import com.example.training.model.dao.Students;
import com.example.training.model.dto.GroupAttachmentDto;
import com.example.training.model.dto.StudentDto;
import com.example.training.repository.GroupRepository;
import com.example.training.repository.GroupStudentRepository;
import com.example.training.repository.StudentRepository;
import com.example.training.service.interfaces.StudentService;
import com.example.training.utill.email.EmailUtils;
import com.example.training.utill.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupStudentRepository groupStudentRepository;

    @Autowired
    EmailUtils emailUtils;

    @Override
    public void addStudents(StudentDto student) {
        Students students = new Students();
        students.setFirstName(student.getFirstName());
        students.setLastName(student.getLastName());

        studentRepository.save(students);
    }

    @Override
    public List<Students> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void attachToGroup(GroupAttachmentDto groupAttachmentDto) throws BadRequestException {
        long studentId = groupAttachmentDto.getStudentId();
        long groupId = groupAttachmentDto.getGroupId();
        Students students = studentRepository.getStudentAvailableForGroup(studentId).orElseThrow(() ->
                new BadRequestException("Student not found or already attends all 5 groups"));
        SportGroup group = groupRepository.getGroupAvailableForStudent(groupId).orElseThrow(() ->
                new BadRequestException("Group not found or already contains 10 students"));

        SportGroupStudents groupStudents = new SportGroupStudents();
        groupStudents.setGroup(group);
        groupStudents.setStudent(students);
        groupStudents.setStudentGroupId(new GroupStudentsId(studentId, groupId));

        String instructorEmail = group.getInstructor().getEmail();
        emailUtils.sendSimpleMessage(instructorEmail, "New Student added to the group", "New Student added to the group");

        groupStudentRepository.save(groupStudents);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
        studentRepository.deleteById(id);
    }
}
