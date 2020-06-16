package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/room")
//@RequestMapping("/admin")
public class RoomController {

    @Autowired
    RoomService roomService;

//    @Autowired
//    RoomTypeService roomTypeService;

//    @ModelAttribute("room")
//    public Room room() {
//        return new Room();
//    }

    @GetMapping
    public String getRooms(Model model) {
        Room room = new Room();
        model.addAttribute(room);
//        model.addAttribute(Status.AVAILABLE);
        return "room";
    }

//    public String getRooms(Model model) {
//        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
//        model.addAttribute("typesOfRooms",roomTypes);
//        return "accommodation";
//    }



    @PostMapping
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


