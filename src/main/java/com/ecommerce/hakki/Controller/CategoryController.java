package com.ecommerce.hakki.Controller;

import com.ecommerce.hakki.Dto.Product.ProductDto;
import com.ecommerce.hakki.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final ProductService productService;

    @GetMapping("/order")
    public List<ProductDto> paramList(@RequestParam("date1") Date date1,
                                      @RequestParam("date2") Date date2,
                                      @RequestParam("category") String category,
                                      @RequestParam("page") int page){

        return productService.getByFilterCategory(date1,date2,category,page);
    }


}
