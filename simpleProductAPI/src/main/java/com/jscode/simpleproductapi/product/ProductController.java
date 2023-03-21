package com.jscode.simpleproductapi.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductInformationWithID(@PathVariable int id) {
        Product product;

        try {
            product = productService.getProductInformationWithID(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productService.generateReturnString(product);
    }

    @GetMapping("")
    public String getProductInformationWithName(@RequestParam("name") String name) {
        Product product;

        try {
            product = productService.getProductInformationWithName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productService.generateReturnString(product);
    }

    @PostMapping("")
    public String postNewProduct(@RequestBody Product newProduct) {
        Product postedProduct;
        String returnString;

        try {
            postedProduct = productService.postNewProduct(newProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productService.generateReturnStringWhenPosted(postedProduct);
    }
}
