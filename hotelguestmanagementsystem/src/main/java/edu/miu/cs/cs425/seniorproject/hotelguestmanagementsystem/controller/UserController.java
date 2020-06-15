package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping(value={"/login"})
    public String signIn(){


        return "login";
    }
/*
    @GetMapping("/users")
    public String getUser(Model model){

        List<User> user=userService.getAllUsers();
        model.addAttribute("allUsers",user);

        return "/userList";
    }*/










}
