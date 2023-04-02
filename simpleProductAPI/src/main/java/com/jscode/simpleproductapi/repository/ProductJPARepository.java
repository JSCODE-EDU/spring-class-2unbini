package com.jscode.simpleproductapi.repository;

import com.jscode.simpleproductapi.entity.Product;
import com.jscode.simpleproductapi.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Long>{

    Optional<Product> findByName(String name);

}
