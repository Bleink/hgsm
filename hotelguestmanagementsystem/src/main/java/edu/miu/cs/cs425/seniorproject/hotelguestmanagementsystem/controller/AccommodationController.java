package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    RoomTypeService roomTypeService;

    @GetMapping
    public String getRooms(Model model) {
        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("typesOfRooms",roomTypes);
        return "accommodation";
    }
}
