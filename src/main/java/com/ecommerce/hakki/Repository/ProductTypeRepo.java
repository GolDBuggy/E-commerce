package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepo extends JpaRepository<ProductType,Long> {

    List<ProductType> findAllByName(String name);
}
