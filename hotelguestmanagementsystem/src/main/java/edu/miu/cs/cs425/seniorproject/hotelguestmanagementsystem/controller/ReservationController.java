package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.ReservationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.ReservationService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.security.Principal;
import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    ServletContext servletContext;
    @GetMapping("/reservation")
    public ModelAndView checkReservation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roomTypes", roomTypeService.getAllRoomTypes());
        modelAndView.addObject("reservationDto", new ReservationDto());
        modelAndView.setViewName("reservation");
        return modelAndView;}

        @ModelAttribute("reservationDto")
        public ReservationDto reservationDto(){
            return new ReservationDto();
        }

        @PostMapping("/reservation")
    public ModelAndView makeReservation(@ModelAttribute("reservationDto") ReservationDto reservation,Principal principal) {
            List<Room> room= (List<Room>) servletContext.getAttribute("roomList");
            Reservation result=  reservationService.makeReservation(reservation,principal.getName(),room);

            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("reservation",result);
            modelAndView.setViewName("confirmation");

     return modelAndView;
    }



}