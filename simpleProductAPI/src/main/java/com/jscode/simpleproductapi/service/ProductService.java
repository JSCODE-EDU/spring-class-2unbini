package com.jscode.simpleproductapi.service;

import com.jscode.simpleproductapi.dto.Product;
import com.jscode.simpleproductapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProductInformationWithID(int id) throws Exception {
        Product product = productRepository.getProductInformationWithID(id);

        if (product == null) {
            throw new NullPointerException();
        }

        return product;
    }

    public Product getProductInformationWithName(String name) throws Exception {
        Product product = productRepository.getProductInformationWithName(name);

        if (product == null) {
            throw new NullPointerException();
        }

        return product;
    }

    public Product postNewProduct(Product newProduct) throws Exception {
        Product postedProduct = productRepository.postNewProduct(newProduct);

        if (postedProduct == null) {
            throw new NullPointerException();
        }

        return postedProduct;
    }

    public String generateReturnString(Product product) {
        if (product.isOnSale) {
            return String.format("product: %s(%d) is now on sale. cost: %d won.", product.name, product.id, product.cost);
        } else {
            return String.format("product: %s(%d) is now out of stock. cost: %d won.", product.name, product.id, product.cost);
        }
    }

    public String generateReturnStringWhenPosted(Product product) {
        return String.format("product No. %d, %s. Now on sale for %d won.", product.id, product.name, product.cost);
    }
}
