package com.cumt.atmsystem.controller;

import com.cumt.atmsystem.domain.BillRecord;
import com.cumt.atmsystem.domain.CreditCard;
import com.cumt.atmsystem.service.BillRecordService;
import com.cumt.atmsystem.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private BillRecordService billRecordService;
    @RequestMapping("/findCreditByAccountId")
    public List<CreditCard> findCreditByAccountId(String id){
        return creditCardService.findByAccountId(id);
    }
    @RequestMapping("/allBills")
    public List<BillRecord> allBills(String id){
        return billRecordService.allBills(id);
    }
}
