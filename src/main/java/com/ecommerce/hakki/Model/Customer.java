package com.ecommerce.hakki.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_surname")
    private String surname;

    @Column(name = "customer_mail")
    private String email;

    @Column(name = "customer_passw")
    private String password;

    @Column(name = "roles")
    private String roles;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "join_time")
    private LocalDate createdTime;

}
