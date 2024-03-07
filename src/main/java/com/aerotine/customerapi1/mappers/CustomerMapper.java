package com.aerotine.customerapi1.mappers;

import com.aerotine.customerapi1.entity.CustomerEntity;
import com.aerotine.customerapi1.openapi.model.Customer;
import com.aerotine.customerapi1.openapi.model.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerResponse toDto(CustomerEntity customerEntity);



    CustomerEntity toEntity(Customer customer);

    List<CustomerResponse> toDto(List<CustomerEntity> customerEntities);
}



