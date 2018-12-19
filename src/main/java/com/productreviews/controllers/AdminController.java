package com.productreviews.controllers;

import com.productreviews.data.CategoryData;
import com.productreviews.data.ProductData;
import com.productreviews.data.UserData;
import com.productreviews.entities.User;
import com.productreviews.repository.CategoryRepository;
import com.productreviews.services.CategoryService;
import com.productreviews.services.ProductService;
import com.productreviews.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {


    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAdminPage() {
        return REDIRECT + ADMIN_CATEGORY_URL;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getAddCategoryPage(Model model) {
        List<CategoryData> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryData());
        return ControllerConstants.ADMIN_ALLCATEGORIES_PAGE;
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") CategoryData categoryData, Model model) {
        categoryService.addCategory(categoryData);
        return REDIRECT + ADMIN_CATEGORY_URL;
    }

    @RequestMapping(value = "/category/{categoryId}/edit", method = RequestMethod.GET)
    public String getEditCategoryPage(@PathVariable Integer categoryId, Model model) {
        CategoryData categoryData = categoryService.getById(categoryId);
        model.addAttribute("categoryData", categoryData);
        model.addAttribute("categoryDataNew", new CategoryData());
        return ADMIN_EDIT_CATEGORY_PAGE;
    }

    @RequestMapping(value = "/category/{categoryId}/edit", method = RequestMethod.POST)
    public String editCategory(@PathVariable Integer categoryId, @ModelAttribute CategoryData categoryNew) {
        categoryService.editCategory(categoryId, categoryNew);
        return REDIRECT + ADMIN_CATEGORY_URL;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAddProductPage(Model model){
        ProductData productData= new ProductData();
        model.addAttribute("productData", productData);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("products", productService.getProducts());
        return ControllerConstants.ADMIN_ADDPRODUCT_PAGE;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productData") ProductData productData, Model model){
        productService.add(productData);
        return REDIRECT + ADMIN_PRODUCT_URL;
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
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

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userData") UserData userData, Model model) {
        userService.addUser(userData);
        return REDIRECT + ADMIN_CATEGORY_URL;
    }


}
