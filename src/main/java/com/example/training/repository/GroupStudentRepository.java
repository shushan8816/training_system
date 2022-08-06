package com.example.training.repository;

import com.example.training.model.SportGroupStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupStudentRepository extends JpaRepository<SportGroupStudents,Long> {
}
