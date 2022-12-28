package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
