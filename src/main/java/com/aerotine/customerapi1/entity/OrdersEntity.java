package com.aerotine.customerapi1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "orders_api")
public class OrdersEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column
   @CreatedDate
   private Date createdDateTime;
   @Column
   private String Status;

   @ManyToOne
   @JoinColumn(name = "customerID", referencedColumnName = "id")
   private CustomerEntity customer;

}
