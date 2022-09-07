package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.domain.Consumer;
import com.example.yin.domain.Metting;
import com.example.yin.service.impl.MeetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MeetingController {
    /**
     * 返回会议列表
     */
    @Autowired
    private MeetingServiceImpl meetingService;


    @RequestMapping(value = "/Meeting/MeetingInfo", method = RequestMethod.GET)
    public Object MeetingInfo(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String meeting_name = req.getParameter("meeting_name").trim();
        String meeting_type = req.getParameter("meeting_type").trim();
        String meeting_place = req.getParameter("meeting_place").trim();
        jsonObject.put("meeting_name", meeting_name);
        jsonObject.put("meeting_type", meeting_type);
        jsonObject.put("meeting_place", meeting_place);

        return meetingService.MeetingInfo(jsonObject);
    }

    /**
     * 新增会议
     */
    @ResponseBody
    @RequestMapping(value = "/Meeting/set", method = RequestMethod.POST)
    public Object addMeeting(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String meeting_name = req.getParameter("meeting_name").trim();
        String meeting_type = req.getParameter("meeting_type").trim();
        String meeting_place = req.getParameter("meeting_place").trim();
        String meeting_topic = req.getParameter("meeting_topic").trim();
        String meeting_remake = req.getParameter("meeting_remake").trim();
        String meeting_time = req.getParameter("meeting_time").trim();


        Metting metting = new Metting();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myTime = new Date();
        try {
            myTime = dateFormat.parse(meeting_time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        metting.setMAeetingName(meeting_name);
        metting.setMeetingType(meeting_type);
        metting.setMeetingPlace(meeting_place);
        metting.setMeetingTopic(meeting_topic);
        metting.setMeetingRemake(meeting_remake);

        metting.setMeetingTime(myTime);

        metting.setCreateTime(new Date());
        metting.setUpdateTime(new Date());


        try {
            boolean res = meetingService.addMetting(metting);
            if (res) {
                jsonObject.put("code", 1);
                jsonObject.put("success", true);
                jsonObject.put("msg", "注册成功");
                jsonObject.put("type", "success");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("success", false);
                jsonObject.put("msg", "注册失败");
                jsonObject.put("type", "error");
            }
            return jsonObject;
        } catch (DuplicateKeyException e) {
            jsonObject.put("code", 2);
            jsonObject.put("success", false);
            jsonObject.put("msg", "添加失败");
            jsonObject.put("type", "error");
            return jsonObject;
        }
    }
    /**
     * 删除会议
     */
    @RequestMapping(value = "/Meeting/delete", method = RequestMethod.GET)
    public Object deletMeeting(HttpServletRequest req) {
        String id = req.getParameter("id");
        return meetingService.deleteMeeting(Integer.parseInt(id));
    }


    /**
     * 更新会议信息
     */
    @ResponseBody
    @RequestMapping(value = "/Meeting/update", method = RequestMethod.POST)
    public Object updateUMeeting(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String meeting_name = req.getParameter("meeting_name").trim();
        String meeting_type = req.getParameter("meeting_type").trim();
        String meeting_place = req.getParameter("meeting_place").trim();
        String meeting_topic = req.getParameter("meeting_topic").trim();
        String meeting_remake = req.getParameter("meeting_remake").trim();
        String meeting_time = req.getParameter("meeting_time").trim();


        Metting meeting = new Metting();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myTime = new Date();
        try {
            myTime = dateFormat.parse(meeting_time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        meeting.setId(Integer.parseInt(id));
        meeting.setMAeetingName(meeting_name);
        meeting.setMeetingType(meeting_type);
        meeting.setMeetingPlace(meeting_place);
        meeting.setMeetingTopic(meeting_topic);
        meeting.setMeetingRemake(meeting_remake);
        meeting.setMeetingTime(myTime);
        meeting.setUpdateTime(new Date());


        boolean res = meetingService.updateMeeting(meeting);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
        }
        return jsonObject;
    }

}
