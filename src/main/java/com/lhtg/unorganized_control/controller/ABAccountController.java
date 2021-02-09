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
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.EncodingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
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





    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


}
