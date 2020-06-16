package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;

import java.util.List;

public interface RoomTypeService {

    public RoomType addRoomType(RoomType roomType);

    public RoomType getRoomType(Long roomTypeId);

    public List<RoomType> getAllRoomTypes();

    public RoomType updateRoomType(RoomType roomType);

    public void deleteRoomType(Long roomTypeId);

    public RoomType findByType(String type);
}
