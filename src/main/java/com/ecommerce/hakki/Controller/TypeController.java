package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Model.ProductType;
import com.ecommerce.hakki.Service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@RequiredArgsConstructor
public class TypeController {

    private final ProductTypeService typeService;


    @GetMapping("/all")
    public ResponseEntity<List<ProductType>> getAll(){
        return ResponseEntity.ok(typeService.types());
    }

    @PostMapping("/save")
    public ProductType save(@RequestBody ProductType productType){
        typeService.saveType(productType);
        return productType;
    }
}
