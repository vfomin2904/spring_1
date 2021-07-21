package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.persist.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/product/")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String getAllProductsPage(Model model, @RequestParam Optional<Integer> min, @RequestParam Optional<Integer>  max){

        List<Product> products;

        if(min.isPresent() && max.isPresent()){
            products = productService.findByPriceBetween(min.get(), max.get());
        } else if(min.isPresent()){
            products = productService.findByPriceGreaterThanEqual(min.get());
        } else if(max.isPresent()){
            products = productService.findByPriceLessThanEqual(max.get());
        } else{
            products = productService.findAll();
        }

        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String getProductPage(Model model, @PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        model.addAttribute(product.get());
        return "product";
    }

    @PostMapping("/update")
    public String getProductPage(Product product){
        productService.save(product);
        logger.info("The data was successfully updated");
        return "redirect:/product/all";
    }

    @GetMapping("/add")
    public String getProductPageAdd(Model model){
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/add")
    public String getProductPageAdd(Product product){
        productService.save(product);
        logger.info("The data was created successfully");
        return "redirect:/product/all";
    }

}