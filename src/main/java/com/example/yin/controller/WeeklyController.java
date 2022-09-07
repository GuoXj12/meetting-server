package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;
import com.example.yin.service.impl.WeeklyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map.Entry;


import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.Iterator;

@RestController
public class WeeklyController {
    /**
     * 返回会议列表
     */
    @Autowired
    private WeeklyServiceImpl weeklyService;


    @RequestMapping(value = "/Weekly/WeeklyInfo", method = RequestMethod.GET)
    public Object WeeklyInfo(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String weeklyYear = req.getParameter("weeklyYear").trim();
        String weeklyDate = req.getParameter("weeklyDate").trim();
        jsonObject.put("weeklyYear", weeklyYear);
        jsonObject.put("weeklyDate", weeklyDate);

        return weeklyService.WeeklyInfo(jsonObject);
    }

    @RequestMapping(value = "/Weekly/WeeklyInfoDetail", method = RequestMethod.GET)
    public Object WeeklyInfoDetail(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String model_date = req.getParameter("model_date").trim();
        jsonObject.put("id", id);
        jsonObject.put("model_date", model_date);
        return weeklyService.WeeklyInfoDetail(jsonObject);
    }

    /**
     * 周报专题会议
     */
    public static Map<String, Object> handleParamToMap(
            HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        for (Entry<String, String[]> entry : request.getParameterMap()
                .entrySet()) {
            String[] arr = entry.getValue();
            String result = "";
            if (null != arr && arr.length > 0) {
                for (int i = 0; i < arr.length; i++) {
                    result += arr[i];
                    if (i < arr.length - 1) {
                        result += ",";
                    }
                }
                map.put(entry.getKey(), result);
            }
        }
        return map;
    }


    @RequestMapping(value = "/Weekly/saveMeetingTopic", method = RequestMethod.POST)
    public Object saveMeetingTopic( HttpServletRequest req) {
        System.out.println("DDDDDDDDDD");
        System.out.println(((handleParamToMap(req))));
        System.out.println("DDDDDDDDDD");
        System.out.println("DDDDDDDDDD");

        return 1;
    }
}
