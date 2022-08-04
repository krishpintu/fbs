package com.ks.fbs.controller;

import com.ks.fbs.dto.UserDto;
import com.ks.fbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
public class RegisterController {


    @RequestMapping("/register")
    public String registerPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "/pages/signup";
    }

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {

        model.addAttribute("user", userDto);

//        User userExists = userService.findByUsername(userDto.getUsername());
//
//        System.out.println("user-->"+userDto.getUsername());
//        System.out.println("userExists-->"+userExists);
//
//        if (userExists != null) {
//            return "redirect:/register?username";
//        }
//        if(result.hasErrors()){
//            model.addAttribute("error", "Registration Failed");
//            return "/pages/signup";
//        }
//        userService.save(userDto);
        return "redirect:/register?success";

    }
}
