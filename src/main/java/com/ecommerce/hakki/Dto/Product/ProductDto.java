package com.ecommerce.hakki.Dto.Product;

import com.ecommerce.hakki.Dto.Customer.CustomerDto;
import com.ecommerce.hakki.Model.Customer;
import com.ecommerce.hakki.Model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private String description;
    private Date registrationTime;
    private CustomerDto customer;
    private BigDecimal price;
    private List<ProductType> productTypes;
}
