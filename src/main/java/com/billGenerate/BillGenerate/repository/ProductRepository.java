package com.billGenerate.BillGenerate.repository;

import com.billGenerate.BillGenerate.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);
}
