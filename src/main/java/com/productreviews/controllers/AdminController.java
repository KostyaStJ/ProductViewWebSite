package com.productreviews.controllers;

import com.productreviews.entities.Category;
import com.productreviews.services.CategoryService;
import com.productreviews.services.ProductService;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.productreviews.controllers.ControllerConstants.ADMIN_PAGE;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;

@Controller
@RequiredArgsConstructor

public class AdminController {


    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage() {
        return ControllerConstants.ADMIN_PAGE;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.GET)
    public String getAddCategoryPage(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return ControllerConstants.ADMIN_ADDCATEGORY_PAGE;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category, Model model) {
        categoryService.addCategory(category);
        return REDIRECT + ADMIN_PAGE;
    }


}
