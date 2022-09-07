package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Dto.CustomerDto;
import com.ecommerce.hakki.Dto.RegisterDto;
import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public RegisterDto save(@RequestBody RegisterDto customer){
        customerService.saveCustomer(customer);

        return customer;
    }

    @GetMapping("/customer/{email}")
    public CustomerDto getCustomer(@PathVariable String email){
        return customerService.getByEmail(email);
    }
}
