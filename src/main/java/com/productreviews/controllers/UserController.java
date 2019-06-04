package com.productreviews.controllers;

import com.productreviews.data.CategoryData;
import com.productreviews.data.UserData;
import com.productreviews.services.CategoryService;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToHomePage(Model model) {
        List<CategoryData> categories = categoryService.getCategories();
        if (!categories.isEmpty()) {
            model.addAttribute("categories", categories);
        } else {
            return ERROR_PAGE;
        }
        return HOME_PAGE;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        UserData userData = new UserData();
        model.addAttribute("userData", userData);
        return ControllerConstants.REGISTER_PAGE;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(@Valid @ModelAttribute("userData") UserData userData, Model model, BindingResult bindingResult) {

        System.out.println("START");
        if (bindingResult.hasErrors()){
            System.out.println("HERE");
            model.addAttribute(userData);
            return REGISTER_PAGE;
        }
        System.out.println("OUT IF");

        userService.addUser(userData);
        return REDIRECT + LOGIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return LOGIN_PAGE;
    }


}
