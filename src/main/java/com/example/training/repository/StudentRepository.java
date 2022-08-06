package com.example.training.repository;

import com.example.training.model.dao.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM students s LEFT JOIN group_students gs on s.id = gs.student_id" +
            " WHERE s.id = :studentId" +
            " GROUP BY  gs.student_id " +
            " HAVING (COUNT(gs.group_id) < 5 )")
    Optional<Students> getStudentAvailableForGroup(long studentId);


}
