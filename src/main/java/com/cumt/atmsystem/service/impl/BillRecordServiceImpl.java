package com.cumt.atmsystem.service.impl;

import com.cumt.atmsystem.domain.BillRecord;
import com.cumt.atmsystem.mapper.BillRecordMapper;
import com.cumt.atmsystem.service.BillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillRecordServiceImpl implements BillRecordService {
    @Autowired
    private BillRecordMapper billRecordMapper;
    @Override
    public List<BillRecord> allBills(String id) {
        return billRecordMapper.findPaidRecordsByCreditCardId(id);
    }
}
