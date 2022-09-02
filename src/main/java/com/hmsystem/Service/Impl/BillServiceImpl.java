package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Billservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Bill;
import com.hmsystem.model.Doctor;
import com.hmsystem.repository.BillRepository;
import com.hmsystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillServiceImpl implements Billservice {

    private BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(long id) {
        return billRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Bill", "Id", id));
    }

    @Override
    public Bill updateBill(Bill bill, long id) {
        // check whether Doctor with given id is exist in DB or not
        Bill existingBill = billRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bill", "Id", id));

        existingBill.setCustomerName(bill.getCustomerName());
        existingBill.setDescription(bill.getDescription());
        existingBill.setQty(bill.getQty());
        existingBill.setDate(bill.getDate());
        existingBill.setAmount(bill.getAmount());
        // save existing Bill to DB
        billRepository.save(existingBill);
        return existingBill;
    }

    @Override
    public void deleteBill(long id) {

        // check whether a employee exist in a DB or not
        billRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Bill", "Id", id));
        billRepository.deleteById(id);
    }

}
