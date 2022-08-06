package com.example.training.service.interfaces;

import com.example.training.model.dao.SportGroup;
import com.example.training.model.dto.GroupDto;
import com.example.training.model.dto.GroupInstrucorDto;
import com.example.training.utill.exceptions.BadRequestException;
import com.example.training.utill.exceptions.DuplicateDataException;
import com.example.training.utill.exceptions.NotFoundException;

import java.util.List;

public interface GroupService {
    void addGroup(GroupDto groupDto) throws BadRequestException, NotFoundException;

    List<SportGroup> getAllGroups();

    void editInstructor(GroupInstrucorDto groupInstrucorDto) throws NotFoundException, DuplicateDataException;
}
