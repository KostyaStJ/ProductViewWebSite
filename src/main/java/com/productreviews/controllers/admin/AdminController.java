package com.productreviews.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.productreviews.controllers.ControllerConstants.ADMIN_CATEGORY_URL;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAdminPage() {
        return REDIRECT + ADMIN_CATEGORY_URL;
    }






}
