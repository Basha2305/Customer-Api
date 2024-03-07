package com.aerotine.customerapi1.Repository;

import com.aerotine.customerapi1.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrdersEntity, Long> {

}
