package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Storeservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Store;
import com.hmsystem.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class StoreServiceImpl implements Storeservice {

    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository StoreRepository) {
        this.storeRepository = StoreRepository;
    }

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(long id) {
        return storeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Store", "Id", id));
    }

    @Override
    public Store updateStore(Store store, long id) {
        // check whether Doctor with given id is exist in DB or not
        Store existingStore = storeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Store", "Id", id));

        existingStore.setMedicineName(store.getMedicineName());
        existingStore.setCategory(store.getCategory());
        existingStore.setMdate(store.getMdate());
        existingStore.setEDate(store.getEDate());
        existingStore.setAvailableQTY(store.getAvailableQTY());
        // save existing Store to DB
        storeRepository.save(existingStore);
        return existingStore;
    }

    @Override
    public void deleteStore(long id) {

        // check whether a Store exist in a DB or not
        storeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Store", "Id", id));
        storeRepository.deleteById(id);
    }
}
