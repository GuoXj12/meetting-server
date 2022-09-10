package com.example.yin.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.example.yin.service.InfoService;

import com.example.yin.domain.Metting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.yin.dao.InfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;


    @Override
    public Map getTotalData() {
        Map<String, Object> result = new HashMap<>();
        String userCount = infoMapper.getUserCount().get("userCount").toString();
        String meetCount = infoMapper.getMeetCount().get("meetCount").toString();
        String weeklyCount = infoMapper.getWeeklyCount().get("weeklyCount").toString();
        String workCount = "0";
        result.put("userCount",userCount);
        result.put("meetCount",meetCount);
        result.put("weeklyCount",weeklyCount);
        result.put("workCount",workCount);

        return result;
    }

    public Map getTypeData() {
        Map<String, Object> result = new HashMap<>();
        String userType1 = infoMapper.getUserType1().get("userCount").toString();
        String userType2 = infoMapper.getUserType2().get("userCount").toString();
        String meetingType1 = infoMapper.getMeetingType1().get("meetingType").toString();
        String meetingType2 = infoMapper.getMeetingType2().get("meetingType").toString();
        String meetingType3 = infoMapper.getMeetingType3().get("meetingType").toString();
        String meetingType4 = infoMapper.getMeetingType4().get("meetingType").toString();
        String meetingType5 = infoMapper.getMeetingType5().get("meetingType").toString();
        String meetingType6 = infoMapper.getMeetingType6().get("meetingType").toString();


        result.put("userType1",userType1);
        result.put("userType2",userType2);
        result.put("meetingType1",meetingType1);
        result.put("meetingType2",meetingType2);
        result.put("meetingType3",meetingType3);
        result.put("meetingType4",meetingType4);
        result.put("meetingType5",meetingType5);
        result.put("meetingType6",meetingType6);

        return result;
    }
}
