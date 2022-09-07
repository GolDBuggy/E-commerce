package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProductType,Long> {
}
