package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.RoomConverter;
import com.creatorx.aslet.dto.RoomCreateDto;
import com.creatorx.aslet.dto.RoomDto;
import com.creatorx.aslet.exception.NotBelongsToUserException;
import com.creatorx.aslet.exception.RoomNotFoundException;
import com.creatorx.aslet.model.Room;
import com.creatorx.aslet.repository.RoomRepository;
import com.creatorx.aslet.utils.AccessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomConverter roomConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessUtils accessUtils;

    public RoomDto createRoom(RoomCreateDto roomCreateDto) {
        Room newRoom = roomConverter.roomCreateDtoToRoom(roomCreateDto);
        newRoom.setOwner(userService.getUserByIdDefault(accessUtils.getUserId()));
        roomRepository.save(newRoom);
        return roomConverter.roomToDto(newRoom);
    }

    public List<RoomDto> getAllRooms() {
        if (accessUtils.isAdmin()) return roomConverter.roomToDto(roomRepository.findAll());
        return roomConverter.roomToDto(roomRepository.findAllByOwner_Id(accessUtils.getUserId()));
    }

    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(room.getOwner().getId())) throw new NotBelongsToUserException();
        return roomConverter.roomToDto(room);
    }

    public Room getRoomByIdDefault(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    public RoomDto updateRoom(RoomDto updatedRoom, Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(room.getOwner().getId())) throw new NotBelongsToUserException();
        room.setName(updatedRoom.getName());
        room.setCapacity(updatedRoom.getCapacity());
        roomRepository.save(room);
        return roomConverter.roomToDto(room);
    }

    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new RoomNotFoundException(id);
        }
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(getRoomByIdDefault(id).getOwner().getId())) throw new NotBelongsToUserException();
        roomRepository.deleteById(id);
    }
}
