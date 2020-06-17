package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.ReservationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.ReservationRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.RoomRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.GuestService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Qualifier("guestServiceImpl")
    @Autowired
    private GuestService guestService;

    @Override
    public Reservation makeReservation(ReservationDto reservation, String email, List<Room> room) {
      room.forEach(System.out::println);
        Reservation res=new Reservation();
        res.setNumberOfNights(reservation.getNumberOfNights());
        res.setCheckinDate(reservation.getCheckInDate());
        res.setCheckoutDate(reservation.getCheckOutDate());
        Long nights= ChronoUnit.DAYS.between(reservation.getCheckInDate(),reservation.getCheckOutDate());
        res.setNumberOfNights(nights);
        Guest guest= guestService.findByEmail(email);
        System.out.println("........no of rooms......"+ guest);
        res.setGuest(guest);
     room.parallelStream().
                limit(reservation.getNumberOfRooms()).
                forEach((rooms)->{
                  Util.updateRoom.accept(rooms,res);
                        roomRepository.save(rooms);
                        }
                   );

      //  room.setRoomStatus(Status.RESERVED);
       // res.setRoom(room);
      //  Reservation result= reservationRepository.save(res);
        return res;
    }

    @Override
    public Reservation getReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return reservation.orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        System.out.println("..........inside service.......");

        List<Reservation> res= reservationRepository.findAll();
        System.out.println("..........inside service......."+res);
        return  res;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation oldReservation = getReservation(reservation.getReservationId());
        oldReservation.setNumberOfNights(reservation.getNumberOfNights());
        oldReservation.setCheckinDate(reservation.getCheckinDate());
    //    oldReservation.setRoomList(reservation.getRoomList());
        return reservationRepository.save(oldReservation);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }
}
