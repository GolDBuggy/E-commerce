package com.ecommerce.hakki.Service;

import com.ecommerce.hakki.Dto.Product.ProductDto;
import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    private final CustomerService customerService;
    private final ProductTypeService productTypeService;

    public List<ProductDto> products(){
        List<ProductDto> productDtos=productRepo.findAll().stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    public void saveProduct(Product product, Principal principal){
        product.setRegistrationTime(new Date());
        product.setCustomer(customerService.findByMail(principal.getName()));
        productRepo.save(product);
    }

    public List<ProductDto> getByFilterCategory(Date date1,Date date2,String category){
        List<ProductDto> products= productRepo.sirala(date1,date2,category).stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return products;
    }

    public Product getById(long id){
        return productRepo.findById(id).get();
    }


}
