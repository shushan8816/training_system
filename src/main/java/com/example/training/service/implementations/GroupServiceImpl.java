package com.example.training.service.implementations;

import com.example.training.model.dao.Instructors;
import com.example.training.model.dao.SportGroup;
import com.example.training.model.dto.GroupDto;
import com.example.training.model.dto.GroupInstrucorDto;
import com.example.training.repository.GroupRepository;
import com.example.training.repository.InstructorRepository;
import com.example.training.service.interfaces.GroupService;
import com.example.training.utill.exceptions.BadRequestException;
import com.example.training.utill.exceptions.DuplicateDataException;
import com.example.training.utill.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public void addGroup(GroupDto groupDto) throws BadRequestException, NotFoundException {
        SportGroup sportGroup = groupRepository.findByInstructorId(groupDto.getInstructorId());
        if (sportGroup != null) {
            throw new BadRequestException("The instructor already has a group");
        } else {
            sportGroup = new SportGroup();
            Instructors instructor = instructorRepository.findById(groupDto.getInstructorId())
                    .orElseThrow(() -> new NotFoundException("Instructor Not Found"));
            sportGroup.setGroupName(groupDto.getGroupName());
            sportGroup.setInstructor(instructor);
            groupRepository.save(sportGroup);
        }
    }

    @Override
    public List<SportGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void editInstructor(GroupInstrucorDto groupInstrucorDto) throws NotFoundException, DuplicateDataException {
        SportGroup sportGroup = groupRepository.findById(groupInstrucorDto.getGroupId())
                .orElseThrow(() -> new NotFoundException("The group not found"));
        Instructors instructors = instructorRepository.findById(groupInstrucorDto.getInstructorId())
                .orElseThrow(() -> new NotFoundException("The instructor not found"));
        int isInstructorAvailable = groupRepository.existsByInstructor(groupInstrucorDto.getInstructorId());
        if (isInstructorAvailable > 0) throw new DuplicateDataException("Instructor already has a group");
        sportGroup.setInstructor(instructors);
        groupRepository.save(sportGroup);
    }

}
