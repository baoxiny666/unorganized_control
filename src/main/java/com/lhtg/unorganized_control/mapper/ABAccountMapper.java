package com.lhtg.unorganized_control.mapper;

import com.lhtg.unorganized_control.entity.ABAccount;
import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ABAccountMapper {
    @Select("<script> with eeeinner as (" +
            "select InLicensePlate inLicensePlate," +
                    "InControllerNo inControllerNo," +
                    "FullName fullName," +
                    "InDateTime inDateTime," +
                    "OutDateTime outDateTIme," +
                    "EnvironmentalCode environmentCode," +
                    "RegisterDate registerDate," +
                    "VIN vin," +
                    "EngineNO engineNO," +
                    "DischargeStage dischargeStage," +
                    "case DischargeStage " +
                        "when '0' then '国0' " +
                        "when '1' then '国1' " +
                        "when '2' then '国2' " +
                        "when '3' then '国3' " +
                        "when '4' then '国4' " +
                        "when '5' then '国5' " +
                        "when '6' then '国6' " +
                        "when 'D' then '电动' " +
                        "when 'X' then '无排放阶段' " +
                        "else DischargeStage " +
                    " end as 'dischargeStageName'," +
                    "AccompanyList accompanyList," +
                    "DrivingLicense drivingLicense," +
                    "ShipmentName shipmentName," +
                    "FreightVolume freightVolume," +
                    "MotorcadeName motorcadeName," +
                    "InPhoto inPhoto," +
                    "OutPhoto outPhoto" +
            "from(" +
                    "select" +
                        "b.InLicensePlate,b.InDateTime,b.OutDateTime," +
                        "a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
                        "a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
                        "a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
                        " from Park_Ledger a " +
                        "inner join Park_InDataDetail b on b.CardInID=a.CardInID " +
                        "left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
                    "union all " +
                    "select" +
                        " b.InLicensePlate,b.InDateTime,b.OutDateTime," +
                        " a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
                        " a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
                        " a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
                    "from Park_Ledger a " +
                    "inner join Park_InOutDataDetail b on b.CardInOutID=a.CardInID " +
                    "left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
                    "union all" +
                    "select " +
                        " b.InLicensePlate,b.InDateTime,b.OutDateTime," +
                        " a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
                        " a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
                        " a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
                    "from Park_Ledger a " +
                    "inner join Park_InOutDataDetail2 b on b.CardInOutID=a.CardInID " +
                    "left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
            ") as cte" +
            "      )" +
            "select * from eeeinner where 1=1 " +
            " <if test=\"inLicensePlate != null and inLicensePlate !=''\">" +
            "   and eeeinner.inLicensePlate like concat('%',#{inLicensePlate},'%') " +
            " </if>" +
            "<if test=\"disChargeStage != null and disChargeStage !=''and disChargeStage !='-1' \">" +
            " and eeeinner.DischargeStage = #{disChargeStage}" +
            "</if>" +
            "<if test=\"motorCadeName != null and motorCadeName !='' \">" +
            " and eeeinner.MotorcadeName like concat('%',#{motorCadeName},'%') " +
            "</if>" +
            "<if test=\"startTime != null and startTime !='' \">" +
            " and   CONVERT(datetime, eeeinner.InDateTime, 23) &gt;= #{startTime}" +
            "</if>" +
            "<if test=\"endTime != null and endTime !='' \">" +
            " and   CONVERT(datetime, eeeinner.InDateTime, 23) &lt;=  #{endTime}" +
            "</if>"+
            " and  eeeinner.InControllerNo IN (#{controllerDoor})   order by eeeinner.InDateTime desc " +
            "</script>")
    List<ABAccount> select(ABAccount aBAccount);
}