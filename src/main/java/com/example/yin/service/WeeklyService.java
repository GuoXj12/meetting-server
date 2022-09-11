package com.example.yin.service;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;
import java.util.*;

import java.util.List;

public interface WeeklyService {

    List<Map<String, Object>> WeeklyInfo(JSONObject params);
    Map<String, Object> WeeklyInfoDetail(JSONObject params);
    boolean setModel(JSONObject params);
    List<Map<String, Object>> getOption();
}
