package com.olegpetrov.practiceproject.repository;

import com.olegpetrov.practiceproject.entity.Brand;
import com.olegpetrov.practiceproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Modifying
    @Query(nativeQuery = true, value = "update products set quantity = quantity + ?2 where id = ?1")
    @Transactional
    void updateProductQuantity(long id, long quantity);
}
