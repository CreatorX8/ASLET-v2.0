package com.creatorx.aslet.repository;

import com.creatorx.aslet.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByOwner_Id(Long id);
}
