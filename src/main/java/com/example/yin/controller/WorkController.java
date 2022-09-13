package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.service.impl.WorkServiceImpl;
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
public class WorkController {
    /**
     * 返回列表
     */
    @Autowired
    private WorkServiceImpl workService;


    @RequestMapping(value = "/Work/WorkInfo", method = RequestMethod.GET)
    public Object WorkInfo(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String work_time = req.getParameter("work_time").trim();
        jsonObject.put("work_time", work_time);
        return workService.WorkInfo(jsonObject);
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "/Work/set", method = RequestMethod.POST)
    public Object addWork(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String work_topic = req.getParameter("work_topic").trim();
        String work_remake = req.getParameter("work_remake").trim();
        String work_time = req.getParameter("work_time").trim();

        JSONObject insertParams = new JSONObject();
        insertParams.put("work_time", work_time);
        insertParams.put("work_remake", work_remake);
        insertParams.put("work_topic", work_topic);

        try {
            boolean res = workService.addWork(insertParams);
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
    @RequestMapping(value = "/Work/delete", method = RequestMethod.GET)
    public Object deletWork(HttpServletRequest req) {
        String id = req.getParameter("id");
        return workService.deletWork(Integer.parseInt(id));
    }


    /**
     * 更新会议信息
     */
    @ResponseBody
    @RequestMapping(value = "/Work/update", method = RequestMethod.POST)
    public Object updateWork(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();


        String work_topic = req.getParameter("work_topic").trim();
        String work_remake = req.getParameter("work_remake").trim();
        String work_time = req.getParameter("work_time").trim();


        JSONObject updateParams = new JSONObject();
        updateParams.put("work_time", work_time);
        updateParams.put("work_remake", work_remake);
        updateParams.put("work_topic", work_topic);


        boolean res = workService.updateWork(updateParams);
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
