package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        customerService.saveCustomer(customer);

        return customer;
    }
}
