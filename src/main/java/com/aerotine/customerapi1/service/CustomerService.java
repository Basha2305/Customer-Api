package com.aerotine.customerapi1.service;

import com.aerotine.customerapi1.Repository.CustomerRepo;
import com.aerotine.customerapi1.entity.CustomerEntity;
import com.aerotine.customerapi1.mappers.CustomerMapper;
import com.aerotine.customerapi1.openapi.api.CustomerApiDelegate;
import com.aerotine.customerapi1.openapi.model.Customer;
import com.aerotine.customerapi1.openapi.model.CustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CustomerService implements CustomerApiDelegate {
    @Autowired
    private CustomerRepo cRepo;
    @Autowired
    private CustomerMapper cMapper;

    @Override
    public CustomerResponse addCustomer(Customer customer) {
        CustomerEntity customerEntity = cMapper.toEntity(customer);
        CustomerEntity savedCustomer = cRepo.save(customerEntity);
        CustomerResponse cResponse = cMapper.toDto(customerEntity);
        return cResponse;
    }

    @Override
    public CustomerResponse deleteCustomer(Integer id) {
        Optional<CustomerEntity> customerEntity = cRepo.findById(Long.valueOf(id));
        if (customerEntity.isPresent()) {
            CustomerEntity customer = customerEntity.get();
            cRepo.delete(customer);
            CustomerResponse cResponse = cMapper.toDto(customer);
            return cResponse;
        }
        throw new RuntimeException(" Failed to delete the Cuustomer might be a wrong value");

    }
    @Override
    public List<CustomerResponse> getCustomer(){
        //List<CustomerResponse> cResponse = new ArrayList<>();
        List<CustomerResponse> cResponse = cMapper.toDto(cRepo.findAll());
     return cResponse;

    }
}
