package com.example.training.model.dao;

import com.example.training.model.SportGroupStudents;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class SportGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank(message = "FistName cannot be blank")
    private String groupName;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    private Instructors instructor;

    @OneToMany(
            mappedBy = "group"
    )
    @JsonManagedReference
    private List<SportGroupStudents> student;

}
