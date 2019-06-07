package com.productreviews.controllers.admin;

import com.productreviews.data.UserData;
import com.productreviews.entities.User;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;

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

    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
    public String getEditUserPage(@PathVariable("userId") Integer userId, Model model){
        UserData userData = userService.getUserById(userId);
        UserData temporaryUserData = new UserData();

        temporaryUserData.setEmail(userData.getEmail());
        temporaryUserData.setName(userData.getName());

        model.addAttribute("user", userData);
        model.addAttribute("userNew", temporaryUserData);


        return ADMIN_EDIT_USER_PAGE;
    }

    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
    public String editUser(@PathVariable("userId") Integer userId, @Valid @ModelAttribute("userNew") UserData userNew,
                           BindingResult bindingResult, @ModelAttribute("user") UserData user, Model model,
                           RedirectAttributes redirectAttributes){

        if (userNew.getPassword()!=null && !userNew.getPassword().isEmpty()) {
            userService.checkPasswordValidityForEditedUser(userNew.getPassword(), bindingResult);
        }


        if (bindingResult.hasErrors()){

            UserData userData = userService.getUserById(userId);
            model.addAttribute("user", userData);
            model.addAttribute("userNew", userNew);

            return ADMIN_EDIT_USER_PAGE;
        }

        userService.editUser(userId, userNew);

        redirectAttributes.addFlashAttribute("message", "User edited successfully");

        return REDIRECT + ADMIN_USER_URL;

    }

}
