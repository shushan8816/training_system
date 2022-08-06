package com.example.training.repository;

import com.example.training.model.dao.SportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<SportGroup, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM sport_group sg WHERE sg.instructor_id = :id")
    SportGroup findByInstructorId(long id);

    SportGroup findAllByGroupName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM sport_group g LEFT JOIN group_students gs on g.id = gs.group_id" +
            " WHERE g.id = :groupId" +
            " GROUP BY gs.group_id" +
            " HAVING (COUNT(gs.student_id) < 10)")
    Optional<SportGroup> getGroupAvailableForStudent(long groupId);


    @Query(nativeQuery = true,value = "SELECT CASE WHEN (SELECT COUNT(g.id) FROM sport_group g WHERE g.instructor_id = :id)> 0 THEN 1 ELSE 0 END")
    int existsByInstructor(long id);
}
