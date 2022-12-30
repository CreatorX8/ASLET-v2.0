package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.Hour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HourRepository extends JpaRepository<Hour, Long> {
    List<Hour> findAllByOwner_Id(Long id);
}
