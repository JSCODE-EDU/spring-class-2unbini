package com.jscode.simpleproductapi.service;
import com.jscode.simpleproductapi.entity.Product;

import com.jscode.simpleproductapi.repository.ProductJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProductService {
    private final ProductJPARepository productJPARepository;

    public List<Product> findAll() {
        return productJPARepository.findAll();
    }

    public Product getProductInformationWithID(Long id) throws Exception {
        Optional<Product> product = productJPARepository.findById(id);

        if (product == null) {
            throw new NullPointerException();
        }

        return product.get();
    }

    public Product postNewProduct(Product newProduct) throws Exception {
        Product postedProduct = productJPARepository.save(newProduct);

        if (postedProduct == null) {
            throw new NullPointerException();
        }

        return postedProduct;
    }
}
