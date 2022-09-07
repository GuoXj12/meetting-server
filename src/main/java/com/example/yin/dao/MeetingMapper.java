package com.example.yin.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingMapper {

    int insert(Metting record);

    List<Metting> MeetingInfo(JSONObject params);

    int deleteMeeting(Integer id);

    int updateMeeting(Metting record);

}
