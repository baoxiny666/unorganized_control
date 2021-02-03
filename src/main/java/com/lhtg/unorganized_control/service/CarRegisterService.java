package com.lhtg.unorganized_control.service;

import com.lhtg.unorganized_control.entity.ParkLedgerLaster;

import java.util.List;

public interface CarRegisterService {
    List<ParkLedgerLaster> select(ParkLedgerLaster parkLedgerLaster);
}
