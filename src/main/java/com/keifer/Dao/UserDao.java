package com.keifer.Dao;


import com.keifer.Base.Adminer;
import com.keifer.Base.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select("select * from adminers")
    List<User> findAll();

    @Update("update adminers set username =#{username}, password=#{password},level=1,useruri=#{useruri},userCompony=#{userCompony},useremail=#{useremail},key=#{key},usersex=#{usersex},userInfo=#{userInfo},userInfp=#{userInfp} where id = #{id}")
    Integer update(User user);

    @Select("select * from adminers where username = #{username}")
    User findByUsername(User user);

    @Select("select * from adminers where username=#{username} and password = #{password}")
    User userLogin(User user);

    @Select("select * from adminers where level = 1")
    List<User> getAdminerData();

    @Insert("insert into adminers values (#{id},#{username},#{password},#{level},#{useruri},#{userCompony},#{useremail},#{usernum},#{key},#{age},#{usersex},#{userInfo},#{userInfp})")
    Integer add(User user);

    @Select("select * from adminers where id = #{id}")
    User findOne(String id);

    @Delete("delete from adminers where id = #{id}")
    Integer delete(String id);

}
