package com.keifer.Base;

import java.sql.Timestamp;
import java.util.Date;

public class Adminer {
    private String id;
    private String name;
    private String code;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String birth;
    private String shcool;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirth(){
        return birth;
    }

    public void setBirth(String birth){
        this.birth = birth;
    }

    public String getShcool() {
        return shcool;
    }

    public void setShcool(String shcool) {
        this.shcool = shcool;
    }

    @Override
    public String toString() {
        return "Adminer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", age='" + age + '\'' +
                ", birth='" + birth + '\'' +
                ", shcool='" + shcool + '\'' +
                '}';
    }
}
