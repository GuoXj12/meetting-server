package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.ListSong;
import com.example.yin.domain.Metting;
import com.example.yin.service.impl.WeeklyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map.Entry;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

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


    @RequestMapping(value = "/Weekly/getOption", method = RequestMethod.GET)
    public Object getTotalData() {
        return weeklyService.getOption();
    }


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
     * 周报模板生成
     */
    @RequestMapping(value = "/Weekly/setModel", method = RequestMethod.GET)
    public Object setModel(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        simple.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String insertDate = req.getParameter("insertDate");
        jsonObject.put("insertDate", insertDate);
        jsonObject.put("date", new Date());

        try {
            int count =weeklyService.modelCount(jsonObject);
            if (count < 1) {
                weeklyService.setModel(jsonObject);
                jsonObject.put("code", 1);
                jsonObject.put("success", true);
                jsonObject.put("msg", "添加成功");
                jsonObject.put("type", "success");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("success", false);
                jsonObject.put("msg", "已存在，请勿重复添加");
                jsonObject.put("type", "error");
            }
            return jsonObject;
        } catch (DuplicateKeyException e) {
            jsonObject.put("code", 2);
            jsonObject.put("success", false);
            jsonObject.put("msg", "添加失败");
            jsonObject.put("type", "error");
            return jsonObject;
        }
    }
    /**
     * 保存会议
     */



    @RequestMapping(value =  "/Weekly/saveMeeting", method = RequestMethod.POST)
    public Object saveMeeting(@RequestParam Map<String, JSONObject> params) {

      //  String InsertId = params.get("insetBasic").get("id").toString();
        System.out.println("KKKKK");
        System.out.println(params.get("insetBasic"));
        System.out.println(params.get("meetingTopic"));
        System.out.println(params.get("meetingAffairs"));
       // System.out.println(params.get("insetBasic").toString());

        System.out.println("KKKKK");
        System.out.println("KKKKK");




        return 1;
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

}
