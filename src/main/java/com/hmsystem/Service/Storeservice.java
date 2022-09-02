package com.hmsystem.Service;

import com.hmsystem.model.Doctor;
import com.hmsystem.model.Store;

import java.util.List;

public interface Storeservice {
    Store saveStore(Store store);
    List<Store> getAllStores();
    Store getStoreById(long id);
    Store updateStore(Store store, long id);
    void deleteStore(long id);
}
