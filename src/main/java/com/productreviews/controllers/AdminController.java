package com.productreviews.controllers;

import com.productreviews.data.CategoryData;
import com.productreviews.data.ProductData;
import com.productreviews.entities.Category;
import com.productreviews.entities.User;
import com.productreviews.services.CategoryService;
import com.productreviews.services.ProductService;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;

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
        CategoryData category = new CategoryData();
        model.addAttribute("category", category);
        return ControllerConstants.ADMIN_ADDCATEGORY_PAGE;
    }

    @RequestMapping(value = "admin/addproduct", method = RequestMethod.GET)
    public String getAddProductPage(Model model){
        ProductData productData= new ProductData();
        model.addAttribute("productData", productData);
        model.addAttribute("categories", categoryService.getCategories());
        return ControllerConstants.ADMIN_ADDPRODUCT_PAGE;
    }

    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productData") ProductData productData, Model model){
        productService.add(productData);
        return REDIRECT + ADMIN_URL;
    }

    @RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") CategoryData categoryData, Model model) {
        categoryService.addCategory(categoryData);
        return REDIRECT + ADMIN_URL;
    }

    @RequestMapping(value = "/admin/allcategories", method = RequestMethod.GET)
    public String getAllCategories(Model model) {

        List<CategoryData> categories = categoryService.getCategories();

            model.addAttribute("categories", categories);
            model.addAttribute("category", new CategoryData());

        return ADMIN_ALLCATEGORIES_PAGE;
    }


    @RequestMapping(value = "/admin/allusers", method = RequestMethod.GET)
    public String getAllUsers(Model model) {

        List<User> users = userService.getUsers();
        if (!users.isEmpty())
        {
            model.addAttribute("users", users);
        }
        else
        {
            return ERROR_PAGE;
        }
        return ADMIN_ALLUSERS_PAGE;
    }


}
