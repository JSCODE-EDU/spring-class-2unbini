package com.jscode.simpleproductapi.service;
import com.jscode.simpleproductapi.entity.Product;
import com.jscode.simpleproductapi.dto.ProductDTO;

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

    public List<ProductDTO> findAll() {
        return transformDTOToEntity(productJPARepository.findAll());
    }

    public ProductDTO getProductInformationWithID(Long id) throws Exception {
        Optional<Product> product = productJPARepository.findById(id);

        if (product.isEmpty()) {
            throw new NullPointerException();
        }

        return transformDTOToEntity(product.get());
    }

    public ProductDTO getProductInformationByName(String name) throws Exception {
        Optional<Product> product = productJPARepository.findByName(name);

        if (product.isEmpty()) {
            throw new NullPointerException();
        }

        return transformDTOToEntity(product.get());
    }

    public Product postNewProduct(Product newProduct) {
        return productJPARepository.save(newProduct);
    }

    private ProductDTO transformDTOToEntity(Product product) {
        return new ProductDTO(product.getName(), product.isOnSale(), product.getCost());
    }

    private List<ProductDTO> transformDTOToEntity(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product: productList) {
            ProductDTO productDTO = new ProductDTO(product.getName(), product.isOnSale(), product.getCost());
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }
}
