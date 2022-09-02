package com.hmsystem.Service;

import com.hmsystem.model.Bill;
import com.hmsystem.model.Patient;

import java.util.List;

public interface Billservice {
    Bill saveBill(Bill bill);
    List<Bill> getAllBills();
    Bill getBillById(long id);
    Bill updateBill(Bill bill, long id);
    void deleteBill(long id);
}
