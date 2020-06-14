package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.CheckIn;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.GuestRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public void addReservation(Guest guest, Reservation reservation) {
        guest.addReservation(reservation);
    }

    @Override
    public Reservation getReservation(Integer roomNumber) {
        return null;
    }

    @Override
    public void checkInGuest(CheckIn checkIn) {

    }

//    @Override
//    public Bill checkOutGuest() {
//        return null;
//    }
}
