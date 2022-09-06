package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);
}
