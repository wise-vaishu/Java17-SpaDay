package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")

public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
            return "user/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }

    @GetMapping("/index")
    public String displayAllUsers(Model model) {
        List<User> users = UserData.getAllUsers();
        model.addAttribute("users", users);
        return "user/index";
    }



}
