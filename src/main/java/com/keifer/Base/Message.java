package com.keifer.Base;

import java.sql.Date;

public class Message {

    private String id;
    private String content;
    private String key;
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", key='" + key + '\'' +
                ", time=" + time +
                '}';
    }
}
