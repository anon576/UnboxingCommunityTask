package com.example.asdf.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.asdf.Entity.Bill;




@Repository
public interface BillRepository extends JpaRepository<Bill,Integer>{
    Optional<Bill> findById(int id);
}
