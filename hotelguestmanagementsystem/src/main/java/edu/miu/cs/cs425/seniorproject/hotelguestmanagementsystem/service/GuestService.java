package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.CheckIn;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;

public interface GuestService {
    public void addReservation(Guest guest, Reservation reservation);

    public  Reservation getReservation(Integer roomNumber);

    public void checkInGuest(CheckIn checkIn);

//    public Bill checkOutGuest();
}
