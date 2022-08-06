package com.example.training.controller;

import com.example.training.model.dao.SportGroup;
import com.example.training.model.dto.GroupDto;
import com.example.training.model.dto.GroupInstrucorDto;
import com.example.training.service.interfaces.GroupService;
import com.example.training.utill.exceptions.BadRequestException;
import com.example.training.utill.exceptions.DuplicateDataException;
import com.example.training.utill.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping()
    public ResponseEntity<Void> addGroup(@RequestBody GroupDto groupDto) throws BadRequestException, NotFoundException {
        groupService.addGroup(groupDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<SportGroup>> getAllGroups(){
        List<SportGroup> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @PatchMapping
    public ResponseEntity<Void>addAndEditInstructor(@RequestBody GroupInstrucorDto groupInstrucorDto) throws NotFoundException, DuplicateDataException {
        groupService.editInstructor(groupInstrucorDto);
        return ResponseEntity.ok().build();
    }
}
