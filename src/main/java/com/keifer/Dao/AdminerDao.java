package com.keifer.Dao;

import com.keifer.Base.Adminer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminerDao {

    @Select("select * from k_table")
    List<Adminer> findAll();

    @Update("select * from k_table where id = #{id}")
    Integer update(Adminer adminer);

    @Insert("insert into k_table values (#{name},#{age},#{birth},#{shcool},#{code},#{id})")
    Integer add(Adminer adminer);

    @Select("select * from k_table where id = #{id}")
    Adminer findOne(String id);

    @Delete("delete from k_table where id = #{id}")
    Integer delete(String id);

    Integer setId(String id);
}
