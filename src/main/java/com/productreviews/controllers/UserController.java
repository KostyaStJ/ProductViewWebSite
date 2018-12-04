package com.productreviews.controllers;

import com.productreviews.entities.User;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.productreviews.controllers.ControllerConstants.LOGIN_PAGE;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAuthPage(Model model) {
        return ControllerConstants.LOGIN_PAGE;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return ControllerConstants.REGISTER_PAGE;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        return REDIRECT + LOGIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return LOGIN_PAGE;
    }


}
