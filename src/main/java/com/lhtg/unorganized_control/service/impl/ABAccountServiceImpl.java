package com.lhtg.unorganized_control.service.impl;

import com.lhtg.unorganized_control.entity.ABAccount;
import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import com.lhtg.unorganized_control.mapper.ABAccountMapper;
import com.lhtg.unorganized_control.mapper.CarRegisterMapper;
import com.lhtg.unorganized_control.service.ABAccountService;
import com.lhtg.unorganized_control.service.CarRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ABAccountServiceImpl implements ABAccountService {

    @Autowired
    private ABAccountMapper aBAccountMapper;

    @Override
    public List<ABAccount> select(ABAccount aBAccount) {
        List<ABAccount> abAccountsList= aBAccountMapper.select(aBAccount);
        return abAccountsList;
    }
}
