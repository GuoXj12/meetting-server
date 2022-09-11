package com.example.yin.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WeeklyMapper {

    List<Map<String, Object>> getOption();
    List<Map<String, Object>> WeeklyInfo(JSONObject params);
    List<Map<String, Object>> WeeklyMeeting(JSONObject params);
    List<Map<String, Object>> WeeklyMeetingTopic(JSONObject params);
    List<Map<String, Object>> WeeklyMeetingAffairs(JSONObject params);

    List<Map<String, Object>> WeeklyNormal(JSONObject params);
    List<Map<String, Object>> WeeklyLvtong(JSONObject params);
    List<Map<String, Object>> WeeklyOther(JSONObject params);
    List<Map<String, Object>> WeeklyNext(JSONObject params);
    Map<String, Object> WeeklyResearch(JSONObject params);
    int setModel(JSONObject params);

}
