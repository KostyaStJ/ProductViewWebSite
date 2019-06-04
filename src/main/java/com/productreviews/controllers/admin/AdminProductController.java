package com.productreviews.controllers.admin;


import com.productreviews.controllers.ControllerConstants;
import com.productreviews.data.ProductData;
import com.productreviews.services.CategoryService;
import com.productreviews.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.productreviews.controllers.ControllerConstants.ADMIN_PRODUCT_URL;
import static com.productreviews.controllers.ControllerConstants.REDIRECT;

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
    public String addProduct(@ModelAttribute("productData") ProductData productData, Model model){
        productService.add(productData);
        return REDIRECT + ADMIN_PRODUCT_URL;
    }


}
