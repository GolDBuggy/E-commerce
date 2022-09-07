package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Dto.Product.ProductDto;
import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
        return ResponseEntity.ok(productService.products());
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product, Principal principal){
        productService.saveProduct(product,principal);
        return product;
    }

    @GetMapping("/get")
    public List<ProductDto> paramList(@RequestParam("date1") Date date1,
                                   @RequestParam("date2") Date date2,
                                   @RequestParam("category") String category){
        logger.info(date1.toString()+" -- "+date2.toString()+" -- "+category);

        return productService.getByFilterCategory(date1,date2,category);
    }
}
