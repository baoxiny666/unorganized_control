package com.lhtg.unorganized_control.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

//关于AB台账相关
@Data
public class ABAccount {
    private Integer _row_number;    //序号
    private String inLicensePlate;//车牌号
    private String inControllerNo;//入口编码
    private String fullName;//入口名称
    private Date inDateTime;//入口时间
    private Date outDateTime;//出口时间
    private String inPhoto;//入场照片
    private String outPhoto;//出场照片
    private String environmentalCode;//环境编码
    private Date registerDate;//注册日期
    private String vin;//车辆识别代码
    private String engineNO;//发动机编号
    private String disChargeStage;//排放阶段

    private String freightVolume;//运输量

    private String shipmentName;//运输货物名称

    private String disChargeStageName;//排放阶段名字

    private String accompanyList;//随车清单
    private String drivingLicense;//行驶证
    private String motorCadeName;//车队名称

    private String startTime;//开始时间
    private String endTime;//结束时间

    private Integer wuZuzhiCurrentPage;//当前页
    private Integer wuZuzhiPageSize;//每一页显示的条数
    private List<String> controllerDoorList;
    private String controllerDoor;//门信息

    private Integer startPageNum;
    private Integer endPageNum;




}
