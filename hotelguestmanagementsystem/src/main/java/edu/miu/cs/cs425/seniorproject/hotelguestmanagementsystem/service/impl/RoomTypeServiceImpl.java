package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.RoomTypeRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType addRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType getRoomType(Long roomTypeId) {
        Optional<RoomType> roomType = roomTypeRepository.findById(roomTypeId);
        return roomType.orElse(null);
    }

    @Override
    public RoomType findByType(String type){
        return roomTypeRepository.findByType(type);
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType updateRoomType(RoomType roomType) {
        RoomType oldRoomType = getRoomType(roomType.getRoomTypeId());
        oldRoomType.setPrice(roomType.getPrice());
        oldRoomType.setDescription(roomType.getDescription());
        oldRoomType.setImagePath(roomType.getImagePath());
        return roomTypeRepository.save(oldRoomType);
    }

    @Override
    public void deleteRoomType(Long roomTypeId) {

        roomTypeRepository.deleteById(roomTypeId);

    }

}
