package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByOwner_Id(Long id);
}
