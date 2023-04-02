package com.jscode.simpleproductapi.controller;

import com.jscode.simpleproductapi.dto.SimpleProduct;
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
    public List<SimpleProduct> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public SimpleProduct getProductInformationWithID(@PathVariable Long id) {
        SimpleProduct product;

        try {
            product = productService.getProductInformationWithID(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    @GetMapping("")
    public SimpleProduct getProductInformationByName(@RequestParam String name) {
        SimpleProduct product;

        try {
            product = productService.getProductInformationByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    @PostMapping("")
    public Product postNewProduct(@RequestBody Product newProduct) {
        return productService.postNewProduct(newProduct);
    }
}
