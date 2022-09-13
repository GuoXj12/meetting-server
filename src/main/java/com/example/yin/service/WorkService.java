package com.example.yin.service;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;

import java.util.List;
import java.util.Map;

public interface WorkService {

    List<Map<String,Object>> WorkInfo(JSONObject params);
    boolean addWork(JSONObject params);
    boolean deletWork(Integer id);
    boolean updateWork(JSONObject params);
}
