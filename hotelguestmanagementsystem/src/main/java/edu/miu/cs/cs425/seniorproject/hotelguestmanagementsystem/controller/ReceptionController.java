package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reception")
public class ReceptionController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public String getAllReservation(Model model){
        List<Reservation> reservationList = reservationService.getAllReservations();
        model.addAttribute("registeredReservation",reservationList);
        return "reservationlist";
    }
}
