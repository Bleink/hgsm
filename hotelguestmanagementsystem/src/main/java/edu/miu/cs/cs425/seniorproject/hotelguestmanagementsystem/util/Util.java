package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.util;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;

import java.util.function.BiConsumer;

public  class Util {

    public static BiConsumer<Room, Reservation> updateRoom=(room,res)->{
        room.setRoomStatus(Status.RESERVED);
        room.setReservation(res);


    };

}
