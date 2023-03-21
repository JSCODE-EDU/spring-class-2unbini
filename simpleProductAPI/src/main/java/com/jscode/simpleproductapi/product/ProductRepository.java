package com.jscode.simpleproductapi.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@Slf4j
public class ProductRepository {
    public List<Product> productList = List.of(
            new Product(1234,"blueShorts", false, 50000),
            new Product(1235, "redTie", true, 40000),
            new Product(1236, "yellowShirts", true, 30000)
    );

    public Product getProductInformationWithID(int id) {
        return getProductWithID(id);
    }

    public Product getProductInformationWithName(String name) {
        return getProductWithName(name);
    }

    public Product postNewProduct(Product newProduct) {
        if (getProductWithName(newProduct.name) == null) {
            productList.add(newProduct);
            return newProduct;
        }

        return null;
    }

    private Product getProductWithID(int id) {
        for (Product product : productList) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    // Q. id 비교할 땐 ==가 되고, name 비교할 땐 ==가 안 되는(null됨) 이유는 뭐지?
    private Product getProductWithName(String name) {
        for (Product product : productList) {
            if (Objects.equals(product.name, name)) {
                return product;
            }
        }
        return null;
    }
}
