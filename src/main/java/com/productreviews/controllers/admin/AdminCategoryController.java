package com.productreviews.controllers.admin;

import com.productreviews.controllers.ControllerConstants;
import com.productreviews.data.CategoryData;
import com.productreviews.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static com.productreviews.controllers.ControllerConstants.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin/category")
public class AdminCategoryController {

    private final CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAddCategoryPage(Model model) {
        List<CategoryData> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryData());
        return ControllerConstants.ADMIN_ALLCATEGORIES_PAGE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory( @Valid @ModelAttribute("category") CategoryData categoryData, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            return "admin/allcategories";
        }

        categoryService.addCategory(categoryData);

        redirectAttributes.addFlashAttribute("message", "Category created successfully");

        return REDIRECT + ADMIN_CATEGORY_URL;
    }

    @RequestMapping(value = "{categoryId}/edit", method = RequestMethod.GET)
    public String getEditCategoryPage(@PathVariable Integer categoryId, Model model) {
        CategoryData categoryData = categoryService.getById(categoryId);
        model.addAttribute("categoryData", categoryData);
        model.addAttribute("categoryDataNew", new CategoryData());
        return ADMIN_EDIT_CATEGORY_PAGE;
    }

    @RequestMapping(value = "/{categoryId}/edit", method = RequestMethod.POST)
    public String editCategory(@PathVariable Integer categoryId, @Valid @ModelAttribute("categoryDataNew")
            CategoryData categoryNew, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            model.addAttribute(categoryNew);
            return ADMIN_EDIT_CATEGORY_PAGE;
        }

        categoryService.editCategory(categoryId, categoryNew);

        redirectAttributes.addFlashAttribute("message", "Category edited successfully");

        return REDIRECT + ADMIN_CATEGORY_URL;
    }



}
