package com.productreviews.controllers.admin;


import com.productreviews.controllers.ControllerConstants;
import com.productreviews.data.ProductData;
import com.productreviews.services.CategoryService;
import com.productreviews.services.ProductService;
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

import static com.productreviews.controllers.ControllerConstants.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin/product")
public class AdminProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAddProductPage(Model model){
        ProductData productData= new ProductData();
        model.addAttribute("productData", productData);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("products", productService.getProducts());
        return ControllerConstants.ADMIN_ADDPRODUCT_PAGE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productData") ProductData productData, Model model,
                             RedirectAttributes redirectAttributes){
        productService.add(productData);

        redirectAttributes.addFlashAttribute("message", "Product added successfully");

        return REDIRECT + ADMIN_PRODUCT_URL;
    }

    @RequestMapping(value = "/{productId}/edit", method = RequestMethod.GET)
    public String getEditProductPage(@PathVariable("productId") Integer productId, Model model){
        ProductData productData = productService.getById(productId);
        model.addAttribute("productData", productData);
        model.addAttribute("productDataNew", new ProductData());

        return ADMIN_EDIT_PRODUCT_PAGE;
    }

    @RequestMapping(value = "/{productId}/edit", method = RequestMethod.POST)
    public String editProduct(@PathVariable("productId") Integer productId, @Valid @ModelAttribute("productDataNew") ProductData productDataNew,
                                BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            ProductData productData = productService.getById(productId);
            model.addAttribute("productData", productData);
            model.addAttribute("productDataNew", productDataNew);
            return ADMIN_EDIT_PRODUCT_PAGE;
        }

        productService.editProduct(productId, productDataNew);

        redirectAttributes.addFlashAttribute("message", "Product edited successfully");

        return REDIRECT + ADMIN_PRODUCT_URL;
    }


}
