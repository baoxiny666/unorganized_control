package com.lhtg.unorganized_control.service;

import com.lhtg.unorganized_control.entity.ABAccount;
import com.lhtg.unorganized_control.entity.ParkLedgerLaster;

import java.util.List;

public interface ABAccountService {
    List<ABAccount> select(ABAccount aBAccount);

    Long selectCount(ABAccount aBAccount);
}
