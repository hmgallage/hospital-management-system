package com.hmsystem.repository;

import com.hmsystem.model.Doctor;
import com.hmsystem.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
