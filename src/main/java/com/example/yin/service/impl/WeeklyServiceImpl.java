package com.example.yin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.dao.WeeklyMapper;
import com.example.yin.domain.Metting;
import com.example.yin.service.WeeklyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class WeeklyServiceImpl implements WeeklyService {

    @Autowired
    private WeeklyMapper weeklyMapper;

    @Override
    public  List<Map<String, Object>> WeeklyInfo(JSONObject params) {
        return weeklyMapper.WeeklyInfo(params);
    }

    @Override
    public  Map<String, Object> WeeklyInfoDetail(JSONObject params) {
        Map<String, Object> result = new HashMap<>();
        String model_date = params.get("model_date").toString();
        result.put("model_date",model_date);
        // 查询会议
        List<Map<String, Object>> meetingTopic = weeklyMapper.WeeklyMeetingTopic(params);
        List<Map<String, Object>> meetingAffairs = weeklyMapper.WeeklyMeetingAffairs(params);
        Map<String, Object> meeting = new HashMap<>();
        meeting.put("meetingTopic",meetingTopic);
        meeting.put("meetingAffairs",meetingAffairs);
        result.put("meeting",meeting);

        // 查询日常工作
        List<Map<String, Object>> normal = weeklyMapper.WeeklyNormal(params);
        result.put("normal",normal);
        // 查询绿通业务
        List<Map<String, Object>> Lvtong = weeklyMapper.WeeklyLvtong(params);
        result.put("Lvtong",Lvtong);
        // 查询其他重点工作
        List<Map<String, Object>> other = weeklyMapper.WeeklyOther(params);
        result.put("other",other);

        // 下一步工作
        List<Map<String, Object>> next = weeklyMapper.WeeklyNext(params);
        result.put("next",next);

        // 待研究事项
        Map<String, Object> research = weeklyMapper.WeeklyResearch(params);
        result.put("research",research);

        return result;
    }
}
