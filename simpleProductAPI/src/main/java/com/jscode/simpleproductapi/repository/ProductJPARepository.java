package com.jscode.simpleproductapi.repository;

import com.jscode.simpleproductapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

}
