package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Dto.Product.ProductDto;
import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(productService.products());
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product, Principal principal){
        productService.saveProduct(product,principal);
        return product;
    }
}
