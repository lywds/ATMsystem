package com.cumt.atmsystem.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BillRecord {
    Integer billId;
    String creditCardId;
    Integer ifPaid;
    BigDecimal billAmount;
    Timestamp deadlineTime;

    String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Integer getIfPaid() {
        return ifPaid;
    }

    public void setIfPaid(Integer ifPaid) {
        this.ifPaid = ifPaid;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public Timestamp getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Timestamp deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
}
