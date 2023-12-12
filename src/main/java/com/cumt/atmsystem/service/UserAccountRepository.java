package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.Transaction;
import com.cumt.atmsystem.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    //public UserAccount findByAccountId(String accountId);
    public boolean saveMoney(Transaction transaction);
}
