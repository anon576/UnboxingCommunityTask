package com.example.asdf.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asdf.Entity.Bill;
import com.example.asdf.Repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepository billRepository;

    @Override
    public String createBill(Bill bill) {
        billRepository.save(bill);
        return "Bill Created Successfully";
    }

    @Override
    public List<Bill> readAllBills() {
        List<Bill> bills = billRepository.findAll();
        return bills;
       
    }

    @Override
    public Bill readBill(int id) {
       Bill bill = billRepository.findById(id).get();
       return bill;
    }

  

     
}