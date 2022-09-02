package com.hmsystem.controller;

import com.hmsystem.Service.Billservice;
import com.hmsystem.model.Bill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private Billservice billservice;

    public BillController(Billservice billservice) {
        super();
        this.billservice = billservice;
    }

    //doctor REST API
    //create
    @PostMapping
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        return new ResponseEntity<Bill>(billservice.saveBill(bill), HttpStatus.CREATED);
    }


    //get
    @GetMapping
    public List<Bill> getAllBills(){
        return billservice.getAllBills();
    }


    //update doctors
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable("id") long id
            , @RequestBody Bill bill){
        return new ResponseEntity<Bill>(billservice.updateBill(bill, id), HttpStatus.OK);

    }


    //Delete doctors
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBill(@PathVariable("id") long id){

        // delete doctor from DB
        billservice.deleteBill(id);

        return new ResponseEntity<String>("Bill Record deleted successfully!.", HttpStatus.OK);
    }
}
