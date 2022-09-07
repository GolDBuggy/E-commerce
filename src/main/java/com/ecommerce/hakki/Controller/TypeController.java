package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Model.ProductType;
import com.ecommerce.hakki.Service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class TypeController {

    private final ProductTypeService typeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<ProductType>> getAllByName(@PathVariable String name){
        return  ResponseEntity.ok(typeService.getByName(name));
    }


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
