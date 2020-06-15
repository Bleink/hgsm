package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @ModelAttribute("roomType")
    public RoomType roomType() {
        return new RoomType();
    }


    @GetMapping("/roomType")
    public String getRoomType(){
        return "roomType";
    }

    @PostMapping("/addRoomType")
    public String addRoomType(@ModelAttribute("roomType") @Valid RoomType roomType){
        roomTypeService.addRoomType(roomType);
        return null;
    }


}
