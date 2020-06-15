package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Status;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/admin")
@RequestMapping("/roomType")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @ModelAttribute("roomType")
    public RoomType roomType() {
        return new RoomType();
    }


    @GetMapping
    public String getRoomType(){


        return "roomType";
    }

    @PostMapping
    public String addRoomType(@ModelAttribute("roomType") @Valid RoomType roomType, Model model){
        roomTypeService.addRoomType(roomType);

        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("registeredRoomTypes",roomTypes);

        return "roomlist";
    }


}
