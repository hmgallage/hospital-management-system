package com.hmsystem.controller;

import com.hmsystem.Service.Patientservice;
import com.hmsystem.Service.Storeservice;
import com.hmsystem.model.Patient;
import com.hmsystem.model.Store;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private Storeservice storeservice;

    public StoreController(Storeservice storeservice) {
        super();
        this.storeservice = storeservice;
    }


    //patient REST API
    @PostMapping
    public ResponseEntity<Store> saveStore(@RequestBody Store store){
        return  new ResponseEntity<Store>(storeservice.saveStore(store), HttpStatus.CREATED);
    }

    //get
    @GetMapping
    public List<Store> getAllStores(){
        return storeservice.getAllStores();
    }

    //get patients by id
    // http://localhost:8080/api/patients/1
    @GetMapping("{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable("id") long storeId){
        return new ResponseEntity<Store>(storeservice.getStoreById(storeId), HttpStatus.OK);
    }

    //update patients
    // http://localhost:8080/api/patients/1
    @PutMapping("{id}")
    public ResponseEntity<Store> updateStore(@PathVariable("id") long id
            ,@RequestBody Store store){
        return new ResponseEntity<Store>(storeservice.updateStore(store, id), HttpStatus.OK);

    }

    //Delete Patients
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStore(@PathVariable("id") long id){

        // delete Store from DB
        storeservice.deleteStore(id);

        return new ResponseEntity<String>("Store deleted successfully!.", HttpStatus.OK);
    }
}
