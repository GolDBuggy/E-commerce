package com.ecommerce.hakki.Service;

import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final BCryptPasswordEncoder encoder;

    private static String DEFAULT="ROLE_USER";

    public List<Customer> getAll(){
        return customerRepo.findAll();
    }

    public void saveCustomer(Customer customer){
        customer.setRoles(DEFAULT);
        customer.setActive(true);
        customer.setPassword(encoder.encode(customer.getPassword()));
        customerRepo.save(customer);
    }
}
