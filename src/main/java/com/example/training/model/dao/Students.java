package com.example.training.model.dao;

import com.example.training.model.SportGroupStudents;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank(message = "FistName cannot be blank")
    private String firstName;

    @NotBlank(message = "LastName cannot be blank")
    private String lastName;


    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<SportGroupStudents> groups;


}
