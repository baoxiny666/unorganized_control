package com.lhtg.unorganized_control.mapper;

import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
// " row_number() over (order by pll.CDateTime desc) xh,\n" +
@Repository
public interface CarRegisterMapper {
    @Select("<script>  select\n" +
            " pll.LicensePlate licensePlate,\n" +
            " CONVERT(varchar(100), pll.CDateTime, 20) cDateTime,\n" +
            " pll.EnvironmentalCode environmentalCode,\n" +
            " pll.RegisterDate registerDate,\n" +
            " pll.VIN vIN,\n" +
            " pll.EngineNO engineNo,\n" +
            " pll.AccompanyList accompanyList,\n" +
            " pll.DrivingLicense drivingLicense,\n" +
            " pll.DischargeStage disChargeStage,\n" +
            " pll.ShipmentName shipmentName,\n" +
            " pll.FreightVolume freightVolumn,\n" +
            " pll.MotorcadeName motorCadeName\n" +
            " from Park_LedgerLaster pll\n" +
            " where 1=1\n" +
            " <if test=\"licensePlate != null and licensePlate !=''\">\n" +
            " and pll.LicensePlate like concat('%',#{licensePlate},'%') \n" +
            " </if>\n" +
            "<if test=\"disChargeStage != null and disChargeStage !=''and disChargeStage !='-1' \">\n" +
            " and pll.DischargeStage = #{disChargeStage}\n" +
            "</if>\n" +
            "<if test=\"motorCadeName != null and motorCadeName !='' \">\n" +
            " and pll.MotorcadeName like concat('%',#{motorCadeName},'%') \n" +
            "</if>\n" +
            "<if test=\"startTime != null and startTime !='' \">\n" +
            " and   CONVERT(datetime, pll.CDateTime, 23) &gt;= #{startTime}\n" +
            "</if>\n" +
            "<if test=\"endTime != null and endTime !='' \">\n" +
            " and   CONVERT(datetime, pll.CDateTime, 23) &lt;=  #{endTime}\n" +
            "</if>\n order by pll.CDateTime desc </script>")
    List<ParkLedgerLaster> chazhao(ParkLedgerLaster parkLedgerLaster);
}
