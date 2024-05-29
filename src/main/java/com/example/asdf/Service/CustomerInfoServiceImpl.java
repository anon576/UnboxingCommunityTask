

package com.example.asdf.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.asdf.Entity.CustomerInfo;
import com.example.asdf.Repository.CustomerInfoRepository;


@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final CustomerInfoRepository customerInfoRepository;

    // Constructor Injection
    public CustomerInfoServiceImpl(CustomerInfoRepository customerInfoRepository) {
        this.customerInfoRepository = customerInfoRepository;
    }

    @Override
    public String createCustomer(CustomerInfo customerInfo) {
        customerInfoRepository.save(customerInfo);
        return "customer addedd successfully";
    }

    @Override
    public List<CustomerInfo> readAllCustomer() {
        return customerInfoRepository.findAll();
    }

    @Override
    public CustomerInfo readCustomer(int id) {
        return customerInfoRepository.findById(id);
    }

    
}