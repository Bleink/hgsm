package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.ReservationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

        @ModelAttribute("reservationDto")
        public ReservationDto reservationDto(){
            return new ReservationDto();
        }

        @PutMapping("/reservation")
    public ModelAndView makeReservation(@ModelAttribute("reservation") Reservation reservation, Room room, Principal principal) {

            Reservation result=  reservationService.makeReservation(reservation,principal.getName(),room);
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("reservation",result);
            modelAndView.setViewName("reservation");

     return modelAndView;
    }

    @GetMapping("/reservation")
    public String checkReservation() {

        return "index";
    }

}