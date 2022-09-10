package com.example.yin.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Metting;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.List;


@Repository
public interface InfoMapper {
    Map<String, Object> getUserCount();
    Map<String, Object> getMeetCount();
    Map<String, Object> getWeeklyCount();

    Map<String, Object> getUserType1();
    Map<String, Object> getUserType2();
    Map<String, Object> getMeetingType1();
    Map<String, Object> getMeetingType2();
    Map<String, Object> getMeetingType3();
    Map<String, Object> getMeetingType4();
    Map<String, Object> getMeetingType5();
    Map<String, Object> getMeetingType6();

}
