package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {
    @GetMapping("/contactUs")
    public String showContact(){
        return "Other/location&ContactUs";
    }
}
