package com.ecommerce.hakki.Repository;

import com.ecommerce.hakki.Model.Product;
import com.ecommerce.hakki.Model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query("select u from Product u left join u.productTypes o where (u.registrationTime between :param1 and :param2) and o.name=:param3 order by u.price desc ")
    List<Product> sirala(@Param("param1")Date date1, @Param("param2") Date date2, @Param("param3")String category);
}
