package com.jscode.simpleproductapi.controller;

import com.jscode.simpleproductapi.entity.Product;
import com.jscode.simpleproductapi.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("")
    public Product getProductInformationWithID(@RequestParam Long id) {
        Product product;

        try {
            product = productService.getProductInformationWithID(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    @PostMapping("")
    public Product postNewProduct(@RequestBody Product newProduct) {
        Product postedProduct;
        String returnString;

        try {
            postedProduct = productService.postNewProduct(newProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return postedProduct;
    }
}
