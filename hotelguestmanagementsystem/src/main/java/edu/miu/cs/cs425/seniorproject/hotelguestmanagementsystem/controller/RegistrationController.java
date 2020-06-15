package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.controller;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService=userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){
        System.out.println("................success....................");
        System.out.println(userDto.getEmail());
      //  User existing = userService.findByEmail(userDto.getEmail());
      /*
        System.out.println(existing);
        if (existing != null){
            System.out.println("................success1....................");
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            System.out.println("................success2....................");
            return "User/signup";
        }*/

        userService.save(userDto);
        System.out.println("................success3....................");
        return "redirect:/signup";
    }
}
