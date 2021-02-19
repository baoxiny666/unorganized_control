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
                    "DischargeStage disChargeStage," +
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
                        " else DischargeStage " +
                    " end as 'disChargeStageName'," +
                    "AccompanyList accompanyList," +
                    "DrivingLicense drivingLicense," +
                    "ShipmentName shipmentName," +
                    "FreightVolume freightVolume," +
                    "MotorcadeName motorCadeName," +
                    "InPhoto inPhoto," +
                    "OutPhoto outPhoto " +
            "from(" +
                    "select " +
                        "b.InLicensePlate,b.InDateTime,b.OutDateTime," +
                        "a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
                        "a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
                        "a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
                        " from Park_Ledger a " +
                        " inner join Park_InDataDetail b on b.CardInID=a.CardInID " +
                        " left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
                    " union all " +
                    " select " +
                        " b.InLicensePlate,b.InDateTime,b.OutDateTime," +
                        " a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
                        " a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
                        " a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
                    " from Park_Ledger a " +
                    " inner join Park_InOutDataDetail b on b.CardInOutID=a.CardInID " +
                    " left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
                    " union all " +
                    " select " +
                        " b.InLicensePlate,b.InDateTime,b.OutDateTime," +
                        " a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
                        " a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
                        " a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
                    " from Park_Ledger a " +
                    " inner join Park_InOutDataDetail2 b on b.CardInOutID=a.CardInID " +
                    " left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
            ") as cte )" +
            "  select _row_number,inLicensePlate,inControllerNo,fullName,inDateTime,outDateTIme,inPhoto,outPhoto,environmentCode,registerDate,vin,engineNO,disChargeStage,disChargeStageName,accompanyList,drivingLicense,shipmentName,freightVolume,motorcadeName " +
            "            from " +
            "            (" +
            "                   select ROW_NUMBER() over(order by InDateTime desc) _row_number,* " +
            "                   from eeeinner " +
            "                   where  1=1 " +
            " <if test=\"inLicensePlate != null and inLicensePlate !=''\">" +
            "   and eeeinner.InLicensePlate like '%' + #{inLicensePlate} + '%' " +
            " </if>" +
            "<if test=\"disChargeStage != null and disChargeStage !='' and disChargeStage !='-1' \">" +
            " and eeeinner.DischargeStage = #{disChargeStage}" +
            "</if>" +
            "<if test=\"motorCadeName != null and motorCadeName !='' \">" +
            " and eeeinner.MotorcadeName like '%' + #{motorCadeName} + '%' " +
            "</if>" +
            "<if test=\" inControllerNo != null and  inControllerNo != '' and inControllerNo !='-1' \">" +
            " and eeeinner.InControllerNo =  #{inControllerNo}  " +
            "</if>" +
            "<if test=\"startTime != null and startTime !='' \">" +
            " and   CONVERT(varchar(100), eeeinner.InDateTime, 20) &gt;= #{startTime}" +
            "</if>" +
            "<if test=\"endTime != null and endTime !='' \">" +
            " and   CONVERT(varchar(100), eeeinner.InDateTime, 20) &lt;=  #{endTime}" +
            "</if>"+
            "<if test=\"controllerDoorList != null and controllerDoorList.size > 0 \">" +
            " and  eeeinner.InControllerNo IN <foreach  item='item' index='index' collection='controllerDoorList' open='(' separator=',' close=')'>#{item}</foreach> "+
            "</if>"+
            "            ) T "+
            " where T._row_number &gt; #{startPageNum} and T._row_number &lt;= #{endPageNum} "+
            "</script>")
    List<ABAccount> select(ABAccount aBAccount);

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
            "DischargeStage disChargeStage," +
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
            " else DischargeStage " +
            " end as 'disChargeStageName'," +
            "AccompanyList accompanyList," +
            "DrivingLicense drivingLicense," +
            "ShipmentName shipmentName," +
            "FreightVolume freightVolume," +
            "MotorcadeName motorCadeName," +
            "InPhoto inPhoto," +
            "OutPhoto outPhoto " +
            "from(" +
            "select " +
            "b.InLicensePlate,b.InDateTime,b.OutDateTime," +
            "a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
            "a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
            "a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
            " from Park_Ledger a " +
            " inner join Park_InDataDetail b on b.CardInID=a.CardInID " +
            " left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
            " union all " +
            " select " +
            " b.InLicensePlate,b.InDateTime,b.OutDateTime," +
            " a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
            " a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
            " a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
            " from Park_Ledger a " +
            " inner join Park_InOutDataDetail b on b.CardInOutID=a.CardInID " +
            " left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
            " union all " +
            " select " +
            " b.InLicensePlate,b.InDateTime,b.OutDateTime," +
            " a.EnvironmentalCode,a.RegisterDate,a.VIN,a.EngineNO," +
            " a.DischargeStage,b.Photo_In as InPhoto,b.Photo_Out as OutPhoto," +
            " a.AccompanyList,a.DrivingLicense,a.ShipmentName,a.FreightVolume,a.MotorcadeName,b.InControllerNo,pct.FullName " +
            " from Park_Ledger a " +
            " inner join Park_InOutDataDetail2 b on b.CardInOutID=a.CardInID " +
            " left join Park_Controller pct on pct.ControllerNo = b.InControllerNo " +
            ") as cte )" +
            " select count(1) count from eeeinner where 1=1 " +
            " <if test=\"inLicensePlate != null and inLicensePlate !=''\">" +
            "   and eeeinner.InLicensePlate like '%' + #{inLicensePlate} + '%' " +
            " </if>" +
            "<if test=\"disChargeStage != null and disChargeStage !='' and disChargeStage !='-1' \">" +
            " and eeeinner.DischargeStage = #{disChargeStage}" +
            "</if>" +
            "<if test=\"motorCadeName != null and motorCadeName !='' \">" +
            " and eeeinner.MotorcadeName like '%' + #{motorCadeName} + '%' " +
            "</if>" +
            "<if test=\" inControllerNo != null and  inControllerNo != '' and inControllerNo !='-1' \">" +
            " and eeeinner.InControllerNo =  #{inControllerNo}  " +
            "</if>" +
            "<if test=\"startTime != null and startTime !='' \">" +
            " and   CONVERT(varchar(100), eeeinner.InDateTime, 20) &gt;= #{startTime}" +
            "</if>" +
            "<if test=\"endTime != null and endTime !='' \">" +
            " and   CONVERT(varchar(100), eeeinner.InDateTime, 20) &lt;=  #{endTime}" +
            "</if>"+
            "<if test=\"controllerDoorList != null and controllerDoorList.size > 0 \">" +
            " and  eeeinner.InControllerNo IN <foreach  item='item' index='index' collection='controllerDoorList' open='(' separator=',' close=')'>#{item}</foreach> "+
            "</if>"+
            "</script>")
    Long selectCount(ABAccount aBAccount);
}
