package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.service.impl.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class InfoController {
    /**
     * 返回会议列表
     */
    @Autowired
    private InfoServiceImpl infoService;


    @RequestMapping(value = "/Info/getTotalData", method = RequestMethod.GET)
    public Object getTotalData() {
        return infoService.getTotalData();
    }


    @RequestMapping(value = "/Info/getTypeData", method = RequestMethod.GET)
    public Object getTypeData() {
        return infoService.getTypeData();
    }
}
