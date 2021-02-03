package com.lhtg.unorganized_control.service.impl;

import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import com.lhtg.unorganized_control.mapper.CarRegisterMapper;
import com.lhtg.unorganized_control.service.CarRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRegisterServiceImpl implements CarRegisterService {

    @Autowired
    private CarRegisterMapper carRegisterMapper;

    @Override
    public List<ParkLedgerLaster> select(ParkLedgerLaster parkLedgerLaster) {
        List<ParkLedgerLaster> parkLedgerLastersList= carRegisterMapper.select(parkLedgerLaster);
        return parkLedgerLastersList;
    }
}
