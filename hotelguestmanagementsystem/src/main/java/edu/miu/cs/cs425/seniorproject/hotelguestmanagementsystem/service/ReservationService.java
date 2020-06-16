package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import org.springframework.data.domain.Page;

public interface ReservationService {
    public Reservation makeReservation(Reservation reservation, String email, Room room);

    public Reservation getReservation(Long reservationId);

    public Page<Reservation> getAllReservations();

    public Reservation updateReservation(Reservation reservation);

    public void cancelReservation(Long reservationId);
}
