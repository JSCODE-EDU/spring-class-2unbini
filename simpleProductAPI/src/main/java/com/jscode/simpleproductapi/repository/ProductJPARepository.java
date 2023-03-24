package com.jscode.simpleproductapi.repository;

import com.jscode.simpleproductapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
}
