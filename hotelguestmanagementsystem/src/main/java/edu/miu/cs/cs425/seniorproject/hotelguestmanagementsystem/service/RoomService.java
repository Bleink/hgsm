package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;

import java.util.List;

public interface RoomService {
    public Room createRoom(Room room);

    public void addRoomToRoomType(Room room, String type);

    public Room getRoom(Long roomId);

    public List<Room> getAllRooms();

    public Room updateRoom(Room room);

    public void deleteRoom(Long room);


}
