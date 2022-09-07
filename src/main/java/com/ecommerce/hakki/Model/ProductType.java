package com.ecommerce.hakki.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long id;

    @Column(name = "type_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_id_type",joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonIgnore
    private List<Product> products;


}
