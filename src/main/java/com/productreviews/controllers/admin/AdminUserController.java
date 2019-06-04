package com.productreviews.controllers.admin;

import com.productreviews.data.UserData;
import com.productreviews.entities.User;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;
import static com.productreviews.controllers.ControllerConstants.ADMIN_CATEGORY_URL;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "admin/user")
public class AdminUserController {

    private final UserService userService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllUsers(Model model) {

        List<User> users = userService.getUsers();
        if (!users.isEmpty())
        {
            model.addAttribute("users", users);
            model.addAttribute("userData", new UserData());
        }
        else
        {
            return ERROR_PAGE;
        }
        return ADMIN_ALLUSERS_PAGE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userData") UserData userData, Model model) {
        userService.addUser(userData);
        return REDIRECT + ADMIN_CATEGORY_URL;
    }
}
