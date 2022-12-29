package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.RoomCreateDto;
import com.creatorx.aslet.dto.RoomDto;
import com.creatorx.aslet.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomConverter {
    public RoomDto roomToDto(Room room) {
        return new RoomDto(room.getId(), room.getName(), room.getCapacity());
    }

    public List<RoomDto> roomToDto(List<Room> rooms) {
        List<RoomDto> roomDtos = new ArrayList<>();
        for (Room room : rooms) {
            roomDtos.add(new RoomDto(room.getId(), room.getName(), room.getCapacity()));
        }
        return roomDtos;
    }

    public Room roomCreateDtoToRoom(RoomCreateDto roomCreateDto) {
        Room room = new Room();
        room.setName(roomCreateDto.getName());
        room.setCapacity(roomCreateDto.getCapacity());
        return room;
    }
}
