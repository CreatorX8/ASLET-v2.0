package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.ClassGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassGroupRepository extends JpaRepository<ClassGroup, Long> {
    List<ClassGroup> findAllByStudentsClass_Owner_Id(Long id);
}
