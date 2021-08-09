package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login_page";
    }

    @GetMapping("/reg")
    public String regPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "reg_page";
    }

    @PostMapping("/reg")
    public String update(@Valid @ModelAttribute("user") UserDto user, BindingResult result) {
        if(!user.getPassword().equals(user.getRepeatPassword())){
            result.rejectValue("repeatPassword", "", "Пароли не совпадают");
        }

        if (result.hasErrors()) {
            return "reg_page";
        }

        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
