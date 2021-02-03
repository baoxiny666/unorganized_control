package com.lhtg.unorganized_control.mapper;

import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRegisterMapper {

    List<ParkLedgerLaster> select(ParkLedgerLaster parkLedgerLaster);
}
