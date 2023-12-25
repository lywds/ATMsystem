package com.cumt.atmsystem.service;

import com.cumt.atmsystem.domain.BillRecord;

import java.util.List;

public interface BillRecordService {
    public List<BillRecord> allBills(String id);
}
