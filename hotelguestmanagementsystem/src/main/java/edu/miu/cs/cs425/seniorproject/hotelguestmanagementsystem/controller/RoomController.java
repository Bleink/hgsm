package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.ReservationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/admin")
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    ServletContext servletContext;

    @ModelAttribute("room")
    public Room room() {
        return new Room();
    }

//    @ModelAttribute("reservationDto")
//    public ReservationDto reservationDto() {
//        return new ReservationDto();
//    }

    @GetMapping("/room")
    public String getRooms(Model model) {

        RoomType[] roomArr = { new RoomType(1l, "Standard", 100.00, "this is kings description", "img/banner.jpg"),
                new RoomType(1l, "Deluxe", 200.00, "this is kings description", "img/banner.jpg"),
                new RoomType(1l, "Superior Deluxe", 300.00, "this is kings description", "img/banner.jpg"),
                new RoomType(1l, "Premier Deluxe", 400.00, "this is kings description", "img/banner.jpg"),
                new RoomType(1l, "Executive Suite", 500.00, "this is kings description", "img/banner.jpg"),
                new RoomType(1l, "Junior Suite", 600.00, "this is kings description", "img/banner.jpg") };

        model.addAttribute("typesOfRooms",roomArr);
        return "accommodation";
    }


    @PostMapping("/checkRooms")
    public String searchRooms(@ModelAttribute("reservationDto") ReservationDto reservationDto, Model model){

        RoomType roomType = roomTypeService.findByType(reservationDto.getRoomType());
        List<Room> roomList = roomService.searchRoom(roomType);
        if(reservationDto.getNumberOfRooms()>roomList.size()){
            return "redirect:/reservation";
        }
        Room room=roomList.get(0);
        reservationDto.setRoom(roomList);

        model.addAttribute("reservationDto", reservationDto);
        model.addAttribute("room", room);

        model.addAttribute("roomId",room.getRoomId());
        model.addAttribute("roomNumber",room.getRoomNumber());
        model.addAttribute("status",room.getRoomStatus());
        servletContext.setAttribute("roomList", roomList);

        return "list-rooms";

    }

    @PostMapping("/room")
    public String addRoom(@ModelAttribute("room") @Valid Room room){
        roomService.createRoom(room);
        return null;
    }
}


