package com.example.asdf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.example.asdf.Entity.Bill;
import com.example.asdf.Service.BillService;
import com.example.asdf.Service.BillServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BillController {

    @Autowired
    BillService billService = new BillServiceImpl();
    @PreAuthorize("hasAuthority('ACCOUNTANT') or hasAuthority('SALES')")
    @GetMapping("/getbill/{id}")
    public Bill getBillByID(@PathVariable int id) {
        return billService.readBill(id);
    }
    
     @PostMapping("/createbill")
     @PreAuthorize("hasAuthority('SALES')")
     public String createBill (@RequestBody Bill bill) {
         
         
         return billService.createBill(bill);
     }
     
     @GetMapping("/getallbill")
     @PreAuthorize("hasAuthority('ACCOUNTANT') or hasAuthority('SALES')")
     public List<Bill> getallbill(){
         return billService.readAllBills();
     }
     
     
}