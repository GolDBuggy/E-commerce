package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
