package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findByGradeAndLetter(int grade, char letter);
}
