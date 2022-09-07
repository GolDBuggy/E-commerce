package com.ecommerce.hakki.Dto.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String name;
    private String surname;
    private String email;
    private LocalDate createdTime;
}
