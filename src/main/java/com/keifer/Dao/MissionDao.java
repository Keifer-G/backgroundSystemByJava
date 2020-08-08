package com.keifer.Dao;

import com.keifer.Base.Adminer;
import com.keifer.Base.Mission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MissionDao {

    @Select("select * from  missions")
    List<Mission> findAll();

    @Update("select * from missions where id = #{id}")
    Integer update(Mission mission);

    @Insert("insert into missions values (#{id},#{mission},#{username},#{key},#{time},#{ervery})")
    Integer add(Mission mission);

    @Select("select * from missions where username = #{username} or ervery = 1")
    List<Mission> getMisiion(Mission mission);

    @Select("select * from missions where id = #{id}")
    Mission findOne(String id);

    @Delete("delete from missions where id = #{id}")
    Integer delete(String id);
}
