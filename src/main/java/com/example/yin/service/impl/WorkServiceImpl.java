package com.example.yin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.dao.WorkMapper;
import com.example.yin.domain.Metting;
import com.example.yin.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private  WorkMapper workMapper;

    /**
     * 新增用户
     */
    @Override
    public boolean addWork(JSONObject params) {
        return workMapper.insert(params) > 0;
    }

    @Override
    public List<Map<String,Object>> WorkInfo(JSONObject params) {
        return workMapper.WorkInfo(params);
    }

    //    修改用户
    @Override
    public boolean updateWork(JSONObject params) {
        return workMapper.updateWork(params) > 0;
    }

    //    删除用户
    @Override
    public boolean deletWork(Integer id) {
        return workMapper.deletWork(id) > 0;
    }

}
