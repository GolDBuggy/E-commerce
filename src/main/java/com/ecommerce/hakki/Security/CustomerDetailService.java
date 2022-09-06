package com.ecommerce.hakki.Security;

import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailService implements UserDetailsService {

    private final CustomerRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer=repo.findByEmail(email);
        return customer.map(CustomerDetails::new).orElseThrow(() -> new UsernameNotFoundException("Email not found!"));
    }
}
