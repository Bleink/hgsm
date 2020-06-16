package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.ReservationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/room")
//@RequestMapping("/admin")
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    ServletContext servletContext;

//    @ModelAttribute("reservationDto")
//    public ReservationDto reservationDto() {
//        return new ReservationDto();
//    }

    @GetMapping
    public String getRooms(Model model) {
        Room room = new Room();
        model.addAttribute(room);
        return "room";
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
    public String addRoom(@ModelAttribute("room") @Valid Room room, Model model){
        roomService.createRoom(room);

        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("registeredRooms",rooms);

        return "roomlist";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRoom(@PathVariable(name = "id") Long id, @ModelAttribute("room") @Valid Room room, Model model){
        roomService.deleteRoom(id);
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("registeredRooms",rooms);
        return "roomlist";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoom(@PathVariable(name = "id") Long id, Model model) {
        Room room = roomService.getRoom(id);
        model.addAttribute(room);
        return "edit_room";
    }

    @PostMapping("/edit/{id}")
    public String editRoom(@PathVariable(name = "id") Long id, @ModelAttribute("room") @Valid Room room, Model model) {
        roomService.updateRoom(room);
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("registeredRooms",rooms);
        return "roomlist";
    }
}


