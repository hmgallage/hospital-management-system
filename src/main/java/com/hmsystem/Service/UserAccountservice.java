package com.hmsystem.Service;

import com.hmsystem.model.Doctor;
import com.hmsystem.model.UserAccount;

import java.util.List;

public interface UserAccountservice {
    UserAccount saveUserAccount(UserAccount userAccount);
    List<UserAccount> getAllUserAccounts();
    UserAccount getUserAccountById(long id);
    UserAccount updateUserAccount(UserAccount userAccount, long id);
    void deleteUserAccount(long id);
}
