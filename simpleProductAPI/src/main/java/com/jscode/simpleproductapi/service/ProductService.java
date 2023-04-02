package com.jscode.simpleproductapi.service;
import com.jscode.simpleproductapi.entity.Product;
import com.jscode.simpleproductapi.dto.SimpleProduct;

import com.jscode.simpleproductapi.repository.ProductJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProductService {
    private final ProductJPARepository productJPARepository;

    public List<SimpleProduct> findAll() {
        return transformDTOToEntity(productJPARepository.findAll());
    }

    public SimpleProduct getProductInformationWithID(Long id) throws Exception {
        Optional<Product> product = productJPARepository.findById(id);

        if (product.isEmpty()) {
            throw new NullPointerException();
        }

        return transformDTOToEntity(product.get());
    }

    public SimpleProduct getProductInformationByName(String name) throws Exception {
        Optional<Product> product = productJPARepository.findByName(name);

        if (product.isEmpty()) {
            throw new NullPointerException();
        }

        return transformDTOToEntity(product.get());
    }

    public Product postNewProduct(Product newProduct) {
        return productJPARepository.save(newProduct);
    }

    private SimpleProduct transformDTOToEntity(Product product) {
        return new SimpleProduct(product.getName(), product.isOnSale(), product.getCost());
    }

    private List<SimpleProduct> transformDTOToEntity(List<Product> productList) {
        List<SimpleProduct> simpleProductList = new ArrayList<>();

        for (Product product: productList) {
            SimpleProduct simpleProduct = new SimpleProduct(product.getName(), product.isOnSale(), product.getCost());
            simpleProductList.add(simpleProduct);
        }

        return simpleProductList;
    }
}
