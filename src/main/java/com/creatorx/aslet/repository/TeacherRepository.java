package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByOwner_Id(Long id);
}
