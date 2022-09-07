package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
