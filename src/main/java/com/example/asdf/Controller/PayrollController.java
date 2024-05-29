package com.example.asdf.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.asdf.Entity.Payroll;
import com.example.asdf.Service.PayrollService;
import com.example.asdf.Service.PayrollServiceImpl;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PayrollController {

    private final PayrollService payrollService;

    // Constructor Injection
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping("/getpayroll/{id}")
    @PreAuthorize("hasAuthority('ACCOUNTANT') or hasAuthority('HR')")
    public Payroll getpayrollByID(@PathVariable int id) {
        return payrollService.readPayroll(id);
    }
    
     @PostMapping("/createpayroll")
     @PreAuthorize("hasAuthority('HR')")
     public String createpayroll (@RequestBody Payroll payrollInfo) {
         
         
         return payrollService.createPayroll(payrollInfo);
     }

     @GetMapping("/getallpayroll")
     @PreAuthorize("hasAuthority('ACCOUNTANT') or hasAuthority('HR')")
     public List<Payroll> getallpayroll(){
         return payrollService.readAllPayrollss();
     }
}
