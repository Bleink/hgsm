package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.ReservationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReservationService {
    public Reservation makeReservation(ReservationDto reservation, String email, List<Room> room);

    public Reservation getReservation(Long reservationId);

    public List<Reservation> getAllReservations();

    public Reservation updateReservation(Reservation reservation);

    public void cancelReservation(Long reservationId);
}
