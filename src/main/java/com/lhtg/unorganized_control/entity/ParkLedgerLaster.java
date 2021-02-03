package com.lhtg.unorganized_control.entity;

import lombok.Data;

@Data
public class ParkLedgerLaster {
    private String licensePlate;//车牌号
    private String environmentalCode;
    private String registerDate;
    private String vIN;
    private String engineNo;
    private String disChargeStage;//排放阶段

    private String accompanyList;//随车清单
    private String drivingLicense;//驾驶证
    private String shipmentName;
    private String freightVolumn;
    private String motorCadeName;//车队名称
    private String cDateTime;//创建时间

    private String startTime;//开始时间
    private String endTime;//结束时间

    private Integer currentPage;//当前页
    private Integer pageSize;//每一页显示的条数
}
