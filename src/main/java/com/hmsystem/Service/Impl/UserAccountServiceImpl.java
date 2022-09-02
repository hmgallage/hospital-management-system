package com.hmsystem.Service.Impl;

import com.hmsystem.Service.UserAccountservice;
import com.hmsystem.exception.ResourceNotFoundException;
import com.hmsystem.model.Patient;
import com.hmsystem.model.UserAccount;
import com.hmsystem.repository.PatientRepository;
import com.hmsystem.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAccountServiceImpl implements UserAccountservice {


    private UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount getUserAccountById(long id) {
        return userAccountRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("UserAccount", "Id", id));
    }

    @Override
    public UserAccount updateUserAccount(UserAccount userAccount, long id) {
        // check whether patient with given id is exist in DB or not
        UserAccount existingUserAccount = userAccountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("UserAccount", "Id", id));

        existingUserAccount.setUserName(userAccount.getUserName());
        existingUserAccount.setUserType(userAccount.getUserType());
        existingUserAccount.setPassword(userAccount.getPassword());
        // save existing UserAccount to DB
        userAccountRepository.save(existingUserAccount);
        return existingUserAccount;
    }


    @Override
    public void deleteUserAccount(long id) {
        // check whether a Patient exist in a DB or not
        userAccountRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", id));
        userAccountRepository.deleteById(id);

    }
}
