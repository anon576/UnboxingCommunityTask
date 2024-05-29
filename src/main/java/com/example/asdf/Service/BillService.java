package com.example.asdf.Service;


import java.util.List;

import com.example.asdf.Entity.Bill;

public interface BillService {
    String createBill(Bill bill);
    List<Bill> readAllBills();
    Bill readBill(int id);


}