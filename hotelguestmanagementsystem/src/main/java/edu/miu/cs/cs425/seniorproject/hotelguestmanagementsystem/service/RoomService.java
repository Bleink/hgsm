package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;

import java.util.List;

public interface RoomService {
    public Room createRoom(Room room);

    public Room getRoom(Long roomId);

    public List<Room> getAllRooms();

    public Room updateRoom(Room room);

    public void deleteRoom(Long room);

    public List<Room> searchRoom(RoomType roomType);

}
