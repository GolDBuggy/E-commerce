package com.ecommerce.hakki.Service;

import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Model.ProductType;
import com.ecommerce.hakki.Repository.ProductRepo;
import com.ecommerce.hakki.Repository.ProductTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductTypeRepo typeRepo;

    public List<ProductType> types(){
        return typeRepo.findAll();
    }

    public void saveType(ProductType productType){
        typeRepo.save(productType);
    }

    public ProductType getById(long id){
        return typeRepo.findById(id).get();
    }


}
