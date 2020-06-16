package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.RoomRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getRoom(Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        return room.orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room updateRoom(Room room) {
        Room oldRoom = getRoom(room.getRoomId());
        oldRoom.setRoomNumber(room.getRoomNumber());
        oldRoom.setRoomStatus(room.getRoomStatus());
        oldRoom.setRoomType(room.getRoomType());
        return roomRepository.save(oldRoom);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);

    }

    @Override
    public List<Room> searchRoom( RoomType roomType){


        return roomRepository.findAllByRoomTypeAndRoomStatus(roomType, Status.AVAILABLE);
    }
}
