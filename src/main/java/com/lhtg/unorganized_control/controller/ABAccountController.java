package com.lhtg.unorganized_control.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhtg.unorganized_control.entity.ABAccount;
import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import com.lhtg.unorganized_control.service.ABAccountService;
import com.lhtg.unorganized_control.service.CarRegisterService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.EncodingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/abAccount")
public class ABAccountController {


    @Autowired
    private ABAccountService aBAccountService;

    //查询AB台账信息
    @RequestMapping("/exportGridData")
    public void  exportGridData(HttpServletResponse response,ABAccount aBAccount) throws Exception {
        String strDateYmdhmsFormat = "yyyy-MM-dd HH:mm:ss";
        String strDateYmdFormat = "yyyy-MM-dd";
        SimpleDateFormat sdfYmdhms = new SimpleDateFormat(strDateYmdhmsFormat);
        SimpleDateFormat sdfYmd = new SimpleDateFormat(strDateYmdFormat);
        Page pages = PageHelper.startPage(aBAccount.getWuZuzhiCurrentPage(),aBAccount.getWuZuzhiPageSize());
        String ControllerDoor = java.net.URLDecoder.decode(aBAccount.getControllerDoor(), "UTF-8");
        String[] doors = ControllerDoor.split(",");
        aBAccount.setControllerDoorList(Arrays.asList(doors));
        List<ABAccount> list = aBAccountService.select(aBAccount);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        HSSFSheet sheet = workbook.createSheet("数据");
        sheet.setColumnWidth(0, 256*30+184);


        // 第一行
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell_00 = row0.createCell(0);
        cell_00.setCellStyle(style);
        cell_00.setCellValue("车牌号");

        HSSFCell cell_01 = row0.createCell(1);
        cell_01.setCellStyle(style);
        cell_01.setCellValue("入口名称");

        HSSFCell cell_02 = row0.createCell(2);
        cell_02.setCellStyle(style);
        cell_02.setCellValue("入场时间");

        HSSFCell cell_03 = row0.createCell(3);
        cell_03.setCellStyle(style);
        cell_03.setCellValue("出场时间");

        HSSFCell cell_04 = row0.createCell(4);
        cell_04.setCellStyle(style);
        cell_04.setCellValue("入场照片");

        HSSFCell cell_05 = row0.createCell(5);
        cell_05.setCellStyle(style);
        cell_05.setCellValue("出场照片");

        HSSFCell cell_06 = row0.createCell(6);
        cell_06.setCellStyle(style);
        cell_06.setCellValue("环保编码");

        HSSFCell cell_07 = row0.createCell(7);
        cell_07.setCellStyle(style);
        cell_07.setCellValue("注册日期");

        HSSFCell cell_08 = row0.createCell(8);
        cell_08.setCellStyle(style);
        cell_08.setCellValue("车辆识别代码");


        HSSFCell cell_09 = row0.createCell(9);
        cell_09.setCellStyle(style);
        cell_09.setCellValue("发动机号码");


        HSSFCell cell_10 = row0.createCell(10);
        cell_10.setCellStyle(style);
        cell_10.setCellValue("排放阶段");


        HSSFCell cell_11 = row0.createCell(11);
        cell_11.setCellStyle(style);
        cell_11.setCellValue("随车清单");

        HSSFCell cell_12 = row0.createCell(12);
        cell_12.setCellStyle(style);
        cell_12.setCellValue("行驶证");


        HSSFCell cell_13 = row0.createCell(13);
        cell_13.setCellStyle(style);
        cell_13.setCellValue("车队名称");


        int currentRow = 1;
        for(int i =0;i<list.size();i++){
            HSSFRow rowrecord = sheet.createRow(currentRow);
            ABAccount excelABAccount = list.get(i);
            HSSFCell cell_record0 = rowrecord.createCell(0);
            cell_record0.setCellStyle(style);
            cell_record0.setCellValue(excelABAccount.getInLicensePlate()==null?"":excelABAccount.getInLicensePlate());


            HSSFCell cell_record1 = rowrecord.createCell(1);
            cell_record1.setCellStyle(style);
            cell_record1.setCellValue(excelABAccount.getFullName()==null?"":excelABAccount.getFullName());

            HSSFCell cell_record2 = rowrecord.createCell(2);
            cell_record2.setCellStyle(style);
            cell_record2.setCellValue(excelABAccount.getInDateTime().toString()==null?"":sdfYmdhms.format(excelABAccount.getInDateTime()));


            HSSFCell cell_record3 = rowrecord.createCell(3);
            cell_record3.setCellStyle(style);
            cell_record3.setCellValue(excelABAccount.getOutDateTime()==null?"":sdfYmdhms.format(excelABAccount.getOutDateTime()));

            HSSFCell cell_record4 = rowrecord.createCell(4);
            cell_record4.setCellStyle(style);
            cell_record4.setCellValue(excelABAccount.getInPhoto()==null?"":excelABAccount.getInPhoto());

            HSSFCell cell_record5 = rowrecord.createCell(5);
            cell_record5.setCellStyle(style);
            cell_record5.setCellValue(excelABAccount.getOutPhoto()==null?"":excelABAccount.getOutPhoto());

            HSSFCell cell_record6 = rowrecord.createCell(6);
            cell_record6.setCellStyle(style);
            cell_record6.setCellValue(excelABAccount.getEnvironmentalCode()==null?"":excelABAccount.getEnvironmentalCode());


            HSSFCell cell_record7 = rowrecord.createCell(7);
            cell_record7.setCellStyle(style);
            cell_record7.setCellValue(excelABAccount.getRegisterDate()==null?"":sdfYmd.format(excelABAccount.getRegisterDate()));

            HSSFCell cell_record8 = rowrecord.createCell(8);
            cell_record8.setCellStyle(style);
            cell_record8.setCellValue(excelABAccount.getVin()==null?"":excelABAccount.getVin());

            HSSFCell cell_record9 = rowrecord.createCell(9);
            cell_record9.setCellStyle(style);
            cell_record9.setCellValue(excelABAccount.getEngineNO()==null?"":excelABAccount.getEngineNO());


            HSSFCell cell_record10 = rowrecord.createCell(10);
            cell_record10.setCellStyle(style);
            cell_record10.setCellValue(excelABAccount.getDisChargeStage()==null?"":excelABAccount.getDisChargeStage());


            HSSFCell cell_record11 = rowrecord.createCell(11);
            cell_record11.setCellStyle(style);
            cell_record11.setCellValue(excelABAccount.getAccompanyList()==null?"":excelABAccount.getAccompanyList());


            HSSFCell cell_record12 = rowrecord.createCell(12);
            cell_record12.setCellStyle(style);
            cell_record12.setCellValue(excelABAccount.getDrivingLicense()==null?"":excelABAccount.getDrivingLicense());

            HSSFCell cell_record13 = rowrecord.createCell(13);
            cell_record13.setCellStyle(style);
            cell_record13.setCellValue(excelABAccount.getMotorCadeName()==null?"":excelABAccount.getMotorCadeName());


            currentRow++;

        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workbook.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("grid.xls").getBytes(), "iso-8859-1"));

        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }

    }


    //查询AB台账信息
    @RequestMapping("/select")
    public String  select(Integer page, Integer rows, ABAccount aBAccount) throws Exception {
        Page pages = PageHelper.startPage(page,rows);
        String ControllerDoor = java.net.URLDecoder.decode(aBAccount.getControllerDoor(), "UTF-8");
        //String ControllerDoor = new String(Base64.decodeBase64(aBAccount.getControllerDoor()));
        String[] doors = ControllerDoor.split(",");
        aBAccount.setControllerDoorList(Arrays.asList(doors));
        List<ABAccount> list = aBAccountService.select(aBAccount);
        PageInfo<ABAccount> pageInfo = new PageInfo<>(list);
        Long total = pages.getTotal();
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", JSONArray.fromObject(pageInfo.getList()));
        String mmmm =  JSONObject.fromObject(map).toString();
        return mmmm;
    }




}
