package com.example.asdf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.asdf.Entity.Payroll;


@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Integer>{
    Payroll findById(int id);
}
