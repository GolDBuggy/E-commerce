package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Model.Address;
import com.ecommerce.hakki.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping("/save")
    public Address save(@RequestBody Address address, Principal principal){
        addressService.saveAddress(address,principal);
        return address;
    }

    @DeleteMapping("/delete/{title}")
    public void deleteAddress(Principal principal,@PathVariable String title){
        addressService.deleteAddress(principal,title);
    }


}
