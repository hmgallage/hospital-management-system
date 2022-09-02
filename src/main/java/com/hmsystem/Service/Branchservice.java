package com.hmsystem.Service;

import com.hmsystem.model.Branch;
import com.hmsystem.model.Patient;

import java.util.List;

public interface Branchservice {
    Branch saveBranch(Branch branch);
    List<Branch> getAllBranches();
    Branch getBranchById(long id);
    Branch updateBranch(Branch branch, long id);
    void deleteBranch(long id);
}
