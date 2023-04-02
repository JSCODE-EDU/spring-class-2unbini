package com.jscode.simpleproductapi.repository;

import com.jscode.simpleproductapi.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJPARepository extends JpaRepository<Store, Long> {

}
