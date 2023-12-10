package com.cumt.atmsystem.domain;

public class UserAccount {
    Integer accountId;
    Integer userId;
    String accountPassword;

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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
