package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.BillRecord;
import com.cumt.atmsystem.domain.CreditCard;
import com.cumt.atmsystem.domain.Transaction;

import java.util.List;

public interface CreditCardService {
    public List<CreditCard> findByAccountId(String id);
}
