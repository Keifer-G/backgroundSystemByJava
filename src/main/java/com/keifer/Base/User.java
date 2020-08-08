package com.keifer.Base;

public class User {

    private String id;
    private String username;
    private String password;
    private Integer level;
    private String useruri;
    private String usersex;
    private String userInfo;
    private String userCompony;
    private Integer usernum;
    private String useremail;
    private String key;
    private String userInfp;
    private Integer age;

    // 补漏字段
    private String compony;
    private String sex;
    private String email;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getCompony() {
        return compony;
    }

    public void setCompony(String compony) {
        this.compony = compony;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", useruri='" + useruri + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", userCompony='" + userCompony + '\'' +
                ", usernum=" + usernum +
                ", useremail='" + useremail + '\'' +
                ", key='" + key + '\'' +
                ", userInfp='" + userInfp + '\'' +
                ", age=" + age +
                ", compony='" + compony + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUseruri() {
        return useruri;
    }

    public void setUseruri(String useruri) {
        this.useruri = useruri;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserCompony() {
        return userCompony;
    }

    public void setUserCompony(String userCompony) {
        this.userCompony = userCompony;
    }

    public Integer getUsernum() {
        return usernum;
    }

    public void setUsernum(Integer usernum) {
        this.usernum = usernum;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserInfp() {
        return userInfp;
    }

    public void setUserInfp(String userInfp) {
        this.userInfp = userInfp;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
