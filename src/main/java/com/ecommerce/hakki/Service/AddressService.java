package com.ecommerce.hakki.Service;

import com.ecommerce.hakki.Model.Address;
import com.ecommerce.hakki.Repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;
    private final CustomerService customerService;

    public List<Address> getAll(){
        return addressRepo.findAll();
    }


    public void saveAddress(Address address, Principal principal){
        address.setCustomerAddress(customerService.findByMail(principal.getName()));
        addressRepo.save(address);
    }

    public void deleteAddress(Principal principal,String title){
        addressRepo.deleteAddressByCustomerAddressAndAndTitle(customerService.findByMail(principal.getName()),title);
    }
}
