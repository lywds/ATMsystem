package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.BillRecord;
import com.cumt.atmsystem.domain.CreditCard;
import com.cumt.atmsystem.mapper.BillRecordMapper;
import com.cumt.atmsystem.mapper.CreditCardMapper;
import com.cumt.atmsystem.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardImpl implements CreditCardService {
    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    public List<CreditCard> findByAccountId(String id) {
        return creditCardMapper.findByAccountId(id);
    }

}
