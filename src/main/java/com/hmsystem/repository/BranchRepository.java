package com.hmsystem.repository;

import com.hmsystem.model.Branch;
import com.hmsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
