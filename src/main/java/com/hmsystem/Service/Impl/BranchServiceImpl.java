package com.hmsystem.Service.Impl;

import com.hmsystem.Service.Branchservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Branch;
import com.hmsystem.model.Patient;
import com.hmsystem.repository.BranchRepository;
import com.hmsystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchServiceImpl implements Branchservice {

    private BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch saveBranch(Branch patient) {
        return branchRepository.save(patient);
    }


    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(long id) {

        return branchRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Branch", "Id", id));
    }

    @Override
    public Branch updateBranch(Branch branch, long id) {

        // check whether patient with given id is exist in DB or not
        Branch existingBranch = branchRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Branch", "Id", id));

        existingBranch.setBranchName(branch.getBranchName());
        existingBranch.setAddress(branch.getAddress());
        existingBranch.setContactNo(branch.getContactNo());

        // save existing Patient to DB
        branchRepository.save(existingBranch);
        return existingBranch;
    }

    @Override
    public void deleteBranch(long id) {

        // check whether a Patient exist in a DB or not
        branchRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Branch", "Id", id));
        branchRepository.deleteById(id);
    }
}

