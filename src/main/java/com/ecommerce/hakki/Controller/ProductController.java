package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Dto.Product.ProductDto;
import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private static Logger logger=Logger.getLogger(ProductController.class.getName());

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity<>(productService.products(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product, Principal principal){
        productService.saveProduct(product,principal);
        return product;
    }


}
