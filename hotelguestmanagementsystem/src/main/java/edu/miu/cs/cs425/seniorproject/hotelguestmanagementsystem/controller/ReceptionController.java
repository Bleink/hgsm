package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ReceptionController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    RoomService roomService;

    @GetMapping("/reception")
    public String getAllReservation(Model model){
        List<Reservation> reservationList = reservationService.getAllReservations();
        System.out.println("............list"+reservationList+".............");
        model.addAttribute("registeredReservation",reservationList);
        return "reservationlist";
    }

    @RequestMapping("/reception/ckeckin/{roomList}")
    public String checkInRooms(@PathVariable(name = "roomList") List<Room> roomList, Model model) {
        roomList.stream().forEach((room1)->{
                room1.setRoomStatus(Status.OCCUPIED);
                roomService.updateRoom(room1);
            });
        List<Reservation> reservationList = reservationService.getAllReservations();
        model.addAttribute("registeredReservation",reservationList);
        return "reservationlist";
        }
}
