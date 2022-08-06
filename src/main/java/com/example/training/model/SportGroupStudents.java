package com.example.training.model;

import com.example.training.model.dao.SportGroup;
import com.example.training.model.dao.Students;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Data
@NoArgsConstructor
public class SportGroupStudents {
    @EmbeddedId
    private GroupStudentsId studentGroupId;

    @ManyToOne
    @MapsId("studentId")
    @JsonBackReference
    private Students student;

    @ManyToOne
    @MapsId("groupId")
    @JsonBackReference
    private SportGroup group;

    public SportGroupStudents(Students students, SportGroup group){
        this.student = students;
        this.group = group;
        this.studentGroupId = new GroupStudentsId(students.getId(),group.getId());
    }

}
