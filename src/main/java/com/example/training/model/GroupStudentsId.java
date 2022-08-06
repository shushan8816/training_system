package com.example.training.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class  GroupStudentsId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "group_id")
    private Long groupId;

    public GroupStudentsId(Long studentId, Long groupId) {
        this.studentId = studentId;
        this.groupId = groupId;
    }

}
