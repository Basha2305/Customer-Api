package com.aerotine.customerapi1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Customers_Table_api")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @OneToMany
    @JoinColumn(name="customerID", referencedColumnName = "id")
    private List<OrdersEntity> orders;

}
