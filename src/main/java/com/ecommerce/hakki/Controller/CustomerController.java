package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Dto.Customer.CustomerDto;
import com.ecommerce.hakki.Dto.Customer.RegisterDto;
import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer/all")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("/save")
    public String save(@RequestBody RegisterDto customer){
        customerService.saveCustomer(customer);

        return "You have successfully registered!";
    }

    @GetMapping("/customer/{email}")
    public CustomerDto getCustomer(@PathVariable String email){
        return customerService.getByEmail(email);
    }

    @DeleteMapping("/customer/delete/{email}")
    public void deleteByEmail(@PathVariable String email){
        customerService.deleteCustomer(email);
    }
}
