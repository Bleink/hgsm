package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.File;

@Controller
public class HomeController {

    @GetMapping(value = {"/home"})
    public String displayHome(Model model) {
        String[] curouselList = curouselPictureList();
        String[] bottomList = indexBottomPictureList();

        model.addAttribute("curouselList", curouselList);
        model.addAttribute("bottomList", bottomList);

        return "index";
    }

    public String[] curouselPictureList() {
        File file = new File("C:\\Users\\asus\\Documents\\GitHub\\hgsm\\hotelguestmanagementsystem\\src\\main\\resources\\static\\img\\curousel");
        String[] fileList = file.list();
        return fileList;
    }

    public String[] indexBottomPictureList() {
        File file = new File("C:\\Users\\asus\\Documents\\GitHub\\hgsm\\hotelguestmanagementsystem\\src\\main\\resources\\static\\img\\indexBottomPictures");
        String[] fileList = file.list();
        return fileList;
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
