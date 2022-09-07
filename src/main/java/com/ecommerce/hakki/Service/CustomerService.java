package com.ecommerce.hakki.Service;

import com.ecommerce.hakki.Dto.Customer.CustomerDto;
import com.ecommerce.hakki.Dto.Customer.RegisterDto;
import com.ecommerce.hakki.ExcepitonHandle.PasswordException;
import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final BCryptPasswordEncoder encoder;
    private final ModelMapper modelMapper;

    private static String DEFAULT="ROLE_USER";

    public List<Customer> getAll(){
        return customerRepo.findAll();
    }

    public void saveCustomer(RegisterDto customerDto){
        checkPass(customerDto.getPassword(),customerDto.getRePassword());
        customerDto.setPassword(encoder.encode(customerDto.getPassword()));
        Customer customer=modelMapper.map(customerDto,Customer.class);
        customer.setCreatedTime(LocalDate.now());
        customer.setRoles(DEFAULT);
        customer.setActive(true);
        customerRepo.save(customer);
    }

    public CustomerDto getByEmail(String email){
        CustomerDto customerDto=modelMapper.map(findByMail(email),CustomerDto.class);
        return customerDto;
    }

    private void checkPass(String pass,String rePass){
        if(!pass.equals(rePass))
            throw new PasswordException("Şifreler eşit değil!");
    }

    public Customer findByMail(String mail){
        return customerRepo.findByEmail(mail).get();
    }

    public void deleteCustomer(String email){
        customerRepo.deleteCustomerByEmail(email);
    }
}
