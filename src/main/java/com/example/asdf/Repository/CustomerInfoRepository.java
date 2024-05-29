package com.example.asdf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.asdf.Entity.CustomerInfo;



@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Integer>{
    CustomerInfo findById(int id);
}
