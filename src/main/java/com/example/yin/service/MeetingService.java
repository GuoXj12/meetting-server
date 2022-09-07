package com.example.yin.service;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;

import java.util.List;

public interface MeetingService {

    List<Metting> MeetingInfo(JSONObject params);
    boolean addMetting(Metting metting);
    boolean deleteMeeting(Integer id);

    boolean updateMeeting(Metting metting);

}
