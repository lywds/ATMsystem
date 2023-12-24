package com.cumt.atmsystem.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;

public class UserAccount {
    String accountId;
    String userId;
    String accountPassword;
    BigDecimal accountBalance;
    BigDecimal usdBalance;
    BigDecimal eurBalance;
    BigDecimal gbpBalance;
    BigDecimal hkdBalance;

    public BigDecimal getUsdBalance() {
        return usdBalance;
    }

    public void setUsdBalance(BigDecimal usdBalance) {
        this.usdBalance = usdBalance;
    }

    public BigDecimal getEurBalance() {
        return eurBalance;
    }

    public void setEurBalance(BigDecimal eurBalance) {
        this.eurBalance = eurBalance;
    }

    public BigDecimal getGbpBalance() {
        return gbpBalance;
    }

    public void setGbpBalance(BigDecimal gbpBalance) {
        this.gbpBalance = gbpBalance;
    }

    public BigDecimal getHkdBalance() {
        return hkdBalance;
    }

    public void setHkdBalance(BigDecimal hkdBalance) {
        this.hkdBalance = hkdBalance;
    }

    String phoneNumber;
    String bankName;

    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
