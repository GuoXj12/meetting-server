package com.example.yin.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface WorkMapper {

    int insert(JSONObject params);

    List<Map<String,Object>> WorkInfo(JSONObject params);

    int deletWork(Integer id);

    int updateWork(JSONObject params);

}
