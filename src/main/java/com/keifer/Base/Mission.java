package com.keifer.Base;

import java.sql.Date;
import java.sql.Timestamp;

public class Mission {

    private String id;
    private String username;
    private String mission;
    private String key;
    private Boolean ervery;
    private Date time;

    @Override
    public String toString() {
        return "Mission{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", mission='" + mission + '\'' +
                ", key='" + key + '\'' +
                ", ervery=" + ervery +
                ", time=" + time +
                '}';
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getErvery() {
        return ervery;
    }

    public void setErvery(Boolean ervery) {
        this.ervery = ervery;
    }

}
