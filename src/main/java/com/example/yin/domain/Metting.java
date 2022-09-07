package com.example.yin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class Metting {

    private Integer id;


    private String meeting_name;

    private String meeting_type;

    private String meeting_place;

    private String meeting_topic;

    private String meeting_remake;

    private Date create_time;

    private Date update_time;

    private Date meeting_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setMAeetingName(String meeting_name) {
        this.meeting_name = meeting_name == null ? null : meeting_name.trim();
    }

    public String geMAeetingName() {
        return meeting_name;
    }


    public void setMeetingType(String meeting_type) {
        this.meeting_type = meeting_type == null ? null : meeting_type.trim();
    }

    public String geMeetingType() {
        return meeting_type;
    }


    public void setMeetingPlace(String meeting_place) {
        this.meeting_place = meeting_place == null ? null : meeting_place.trim();
    }

    public String geMeetingPlace() {
        return meeting_place;
    }


    public void setMeetingTopic(String meeting_topic) {
        this.meeting_topic = meeting_topic == null ? null : meeting_topic.trim();
    }

    public String geMeetingTopic() {
        return meeting_topic;
    }

    public void setMeetingRemake(String meeting_remake) {
        this.meeting_remake = meeting_remake == null ? null : meeting_remake.trim();
    }

    public String getMeetingRemake() {
        return meeting_remake;
    }


    public Date getMeetingTime() {
        return meeting_time;
    }

    public void setMeetingTime(Date meeting_time) {
        this.meeting_time = meeting_time;
    }

    public Date getCreateTime() {
        return create_time;
    }

    public void setCreateTime(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdateTime() {
        return update_time;
    }

    public void setUpdateTime(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
