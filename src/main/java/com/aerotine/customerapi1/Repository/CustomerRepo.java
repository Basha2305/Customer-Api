package com.aerotine.customerapi1.Repository;

import com.aerotine.customerapi1.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    public List<CustomerEntity> findAll();
}
