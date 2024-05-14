package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

//    @PostMapping
//    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
//
////        model.addAttribute("user", user);
////        model.addAttribute("verify", verify);
////        model.addAttribute("username", user.getUsername());
////        model.addAttribute("email", user.getEmail());
//
////        if (user.getPassword().equals(verify)) {
////            return "user/index";
////        }
////        else {
////            model.addAttribute("error", "Passwords do not match");
////            return "user/add";
////        }
//
//        model.addAttribute(user);
//        boolean verified = user.getPassword().equals(user.getVerify());
//
//        if (!errors.hasErrors() && verified) {
//            return "user/index";
//        }
//        else {
//            if (!verified){
//                model.addAttribute("error", "Passwords do not match");
//            }
//            return "user/add";
//        }
//    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "user/add";
        }
        return "user/index";
    }

}