package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
//@RequestMapping("/admin")
public class RoomController {

    @Autowired
    RoomService roomService;

    @ModelAttribute("room")
    public Room room() {
        return new Room();
    }

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

    @PostMapping("/room")
    public String addRoom(@ModelAttribute("room") @Valid Room room){
        roomService.createRoom(room);
        return null;
    }
}


