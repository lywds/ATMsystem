package com.cumt.atmsystem.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;

public class UserAccount {
    Integer accountId;
    Integer userId;
    String accountPassword;
    BigDecimal accountBalance;
    String phoneNumber;
    String bankName;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountBalance=" + accountBalance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
