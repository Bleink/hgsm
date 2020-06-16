package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.ReservationRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.GuestService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Qualifier("guestServiceImpl")
    @Autowired
    private GuestService guestService;

    @Override
    public Reservation makeReservation(Reservation reservation, String email, Room room) {

        Guest guest=guestService.findByEmail(email);
        reservation.setGuest(guest);
        room.setRoomStatus(Status.RESERVED);
        reservation.setRoom(room);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return reservation.orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation oldReservation = getReservation(reservation.getReservationId());
        oldReservation.setNumberOfNights(reservation.getNumberOfNights());
        oldReservation.setReservationDate(reservation.getReservationDate());
        oldReservation.setRoom(reservation.getRoom());
        return reservationRepository.save(oldReservation);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }
}
