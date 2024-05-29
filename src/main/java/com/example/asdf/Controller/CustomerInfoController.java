package com.example.asdf.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.asdf.Entity.CustomerInfo;
import com.example.asdf.Service.CustomerInfoService;

@RestController
@PreAuthorize("hasAuthority('SALES')")
public class CustomerInfoController {

    private final CustomerInfoService customerInfoService;
    
    // Constructor Injection
    public CustomerInfoController(CustomerInfoService customerInfoService) {
        this.customerInfoService = customerInfoService;
    }
    
    @GetMapping("/getcustomer/{id}")
    public CustomerInfo getcustomerByID(@PathVariable int id) {
        return customerInfoService.readCustomer(id);
    }
    
     @PostMapping("/createcustomer")
     public String createcustomer (@RequestBody CustomerInfo customerInfo) {
         
         
         return customerInfoService.createCustomer(customerInfo);
     }

     @GetMapping("/getallcustomer")
     public List<CustomerInfo> getallcustomer(){
         return customerInfoService.readAllCustomer();
     }
    
}