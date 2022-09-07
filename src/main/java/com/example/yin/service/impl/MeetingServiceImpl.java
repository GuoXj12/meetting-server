package com.example.yin.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Consumer;
import com.example.yin.service.MeetingService;

import com.example.yin.domain.Metting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.yin.dao.MeetingMapper;
import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingMapper mettingMapper;

    /**
     * 新增用户
     */
    @Override
    public boolean addMetting(Metting metting) {
        return mettingMapper.insert(metting) > 0;
    }

    @Override
    public List<Metting> MeetingInfo(JSONObject params) {
        return mettingMapper.MeetingInfo(params);
    }

    //    修改用户
    @Override
    public boolean updateMeeting(Metting metting) {
        return mettingMapper.updateMeeting(metting) > 0;
    }

    //    删除用户
    @Override
    public boolean deleteMeeting(Integer id) {
        return mettingMapper.deleteMeeting(id) > 0;
    }

}
