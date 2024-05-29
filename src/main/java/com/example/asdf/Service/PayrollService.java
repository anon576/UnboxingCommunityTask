package com.example.asdf.Service;

import java.util.List;

import com.example.asdf.Entity.Payroll;

public interface PayrollService {
    String createPayroll(Payroll payroll);
    List<Payroll> readAllPayrollss();
    Payroll readPayroll(int id);

}
