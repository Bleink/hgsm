package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.ReservationRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Reservation makeReservation(Reservation reservation) {
        List<RoomType> roomTypes = reservation.getRoomTypeList();
        for (RoomType roomType : roomTypes) {
            for (Room room : roomType.getRoomList()) {
                if (room.getRoomStatus().equals(Status.AVAILABLE)) {
                    Integer roomNumber = room.getRoomNumber();
                    reservation.setRoomNumber(roomNumber);
                    room.setRoomStatus(Status.RESERVED);
                }
            }
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return reservation.orElse(null);
    }

    @Override
    public Reservation getReservation(Integer roomNumber) {
        List<Reservation> reservationList = reservationRepository.findAll();
        for (Reservation reservation : reservationList) {
            if(reservation.getRoomNumber().equals(roomNumber)) {
                return  reservation;
            }
        }
        return null;
    }

    @Override
    public Page<Reservation> getAllReservations() {
        return reservationRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "reservationDate")));
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation oldReservation = getReservation(reservation.getReservationId());
        oldReservation.setNumberOfNights(reservation.getNumberOfNights());
        oldReservation.setReservationDate(reservation.getReservationDate());
        oldReservation.setRoomTypeList(reservation.getRoomTypeList());
        return reservationRepository.save(oldReservation);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }
}
