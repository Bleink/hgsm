package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/home"})
    public String displayHome(){
          return "Home/index";
    }

}
