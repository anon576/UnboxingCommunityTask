


package com.example.asdf.Service;

import java.util.List;
import com.example.asdf.Entity.CustomerInfo;

public interface CustomerInfoService {
    String createCustomer(CustomerInfo customerInfo);
    List<CustomerInfo> readAllCustomer();
    CustomerInfo readCustomer(int id);
    
}