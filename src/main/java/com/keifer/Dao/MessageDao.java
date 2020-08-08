package com.keifer.Dao;

import com.keifer.Base.Adminer;
import com.keifer.Base.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageDao {
    @Select("select * from messages")
    List<Message> findAll();

    @Update("select * from messages where id = #{id}")
    Integer update(Message message);

    @Insert("insert into messages values (#{id},#{content},#{time},#{key})")
    Integer add(Message message);

    @Select("select * from messages where id = #{id}")
    Message findOne(String id);

    @Delete("delete from messages where id = #{id}")
    Integer delete(String id);
}
