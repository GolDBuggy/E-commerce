package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Address;
import com.ecommerce.hakki.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface AddressRepo extends JpaRepository<Address,Long> {

    @Transactional
    public void deleteAddressByCustomerAddressAndAndTitle(Customer customer,String title);
}
