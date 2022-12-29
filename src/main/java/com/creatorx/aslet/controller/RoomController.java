package com.creatorx.aslet.controller;

import com.creatorx.aslet.dto.RoomCreateDto;
import com.creatorx.aslet.dto.RoomDto;
import com.creatorx.aslet.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<RoomDto> createRoom(@RequestBody @Valid RoomCreateDto newRoom) {
        return ResponseEntity.ok(roomService.createRoom(newRoom));
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PutMapping("/room/{id}")
    public ResponseEntity<RoomDto> updateRoom(@RequestBody @Valid RoomDto updatedRoom, @PathVariable Long id) {
        return ResponseEntity.ok(roomService.updateRoom(updatedRoom, id));
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
