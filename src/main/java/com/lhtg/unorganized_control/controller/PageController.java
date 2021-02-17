package com.lhtg.unorganized_control.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping(value = {"/","/login"})
    public  String login(){
        return "login/login";
    }

    @RequestMapping(value = {"/maintenance/index"})
    public  String maintenance(){
        return "maintenance/index";
    }


    @RequestMapping(value = {"/maintenance/inout"})
    public  String maintenanceinout(){
        return "maintenance/inout";
    }

}
