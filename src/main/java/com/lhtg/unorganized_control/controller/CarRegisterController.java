package com.lhtg.unorganized_control.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhtg.unorganized_control.entity.ParkLedgerLaster;
import com.lhtg.unorganized_control.service.CarRegisterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;

import java.util.List;

@RestController
@RequestMapping("/api/carRegister")
public class CarRegisterController {


    @Autowired
    private CarRegisterService carRegisterService;

    //查询车辆登记信息
    @RequestMapping("/select")
    public String  select(Integer page, Integer rows,ParkLedgerLaster parkLedgerLaster){
        PageHelper.startPage(page,rows);
        List<ParkLedgerLaster> list = carRegisterService.select(parkLedgerLaster);
        PageInfo<ParkLedgerLaster> pageInfo = new PageInfo<>(list);
        String content = JSON.toJSONString(pageInfo);
        return content;
    }


}
