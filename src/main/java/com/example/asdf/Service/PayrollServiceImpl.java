package com.example.asdf.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.asdf.Entity.Payroll;
import com.example.asdf.Repository.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService{

    private final PayrollRepository payrollRepository;

    // Constructor Injection
    public PayrollServiceImpl(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }
    
    @Override
    public String createPayroll(Payroll payroll) {
        payrollRepository.save(payroll);
        return "Payroll added";
    }

    @Override
    public List<Payroll> readAllPayrollss() {
        return payrollRepository.findAll();
    }

    @Override
    public Payroll readPayroll(int id) {
        return payrollRepository.findById(id);
    }
    
}
