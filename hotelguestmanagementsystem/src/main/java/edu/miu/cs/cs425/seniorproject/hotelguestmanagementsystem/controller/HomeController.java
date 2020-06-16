package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping(value = {"/home"})
    public String displayHome(Model model) {
        String[] curouselList = homeService.getCurouselPictureList();
        String[] bottomList = homeService.getIndexBottomPictureList();

        model.addAttribute("curouselList", curouselList);
        model.addAttribute("bottomList", bottomList);

        return "index";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
