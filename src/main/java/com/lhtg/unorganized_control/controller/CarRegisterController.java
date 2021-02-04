package com.lhtg.unorganized_control.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import com.lhtg.unorganized_control.service.CarRegisterService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carRegister")
public class CarRegisterController {


    @Autowired
    private CarRegisterService carRegisterService;

    //查询车辆登记信息
    @RequestMapping("/select")
    public String  select(Integer page, Integer rows,ParkLedgerLaster parkLedgerLaster){
        Page pages = PageHelper.startPage(page,rows);
        List<ParkLedgerLaster> list = carRegisterService.select(parkLedgerLaster);
        PageInfo<ParkLedgerLaster> pageInfo = new PageInfo<>(list);
        Long total = pages.getTotal();
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", JSONArray.fromObject(pageInfo.getList()));
        String mmmm =  JSONObject.fromObject(map).toString();
        return mmmm;
    }


}
