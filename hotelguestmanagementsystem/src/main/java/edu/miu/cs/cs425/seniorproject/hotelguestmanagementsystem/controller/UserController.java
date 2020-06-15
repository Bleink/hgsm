package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Address;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Role;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String signIn(){ return "login";
    }

    @PostMapping("/user")
    public String createUser(Model model) {
        Address address = new Address();
        address.setStreet("1000 N 4th Str");
        address.setCity("FairField");
        address.setState("Iowa");
        address.setZipcode("52557");
        User user = new User();
        user.setFirstName("Blein");
        user.setLastName("Yirdaw");
        user.setUserName("Blein");
        user.setPassword("12345678");
        user.setEmail("xyz@gmail.com");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ADMIN"));
        roles.add(new Role("GUEST"));
        roles.add(new Role("RECEPTION"));
        user.setRoles(roles);
        user.setCellPhoneNumber("641-451-3930");
        user.setAddress(address);
        userService.createUser(user);
        return null;
    }


/*
    @GetMapping("/users")
    public String getUser(Model model){

        List<User> user=userService.getAllUsers();
        model.addAttribute("allUsers",user);

        return "/userList";
    }*/










}
