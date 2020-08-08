package com.keifer.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("mysql")
public class Mysql {

    public void getData() {
        final List<Object> list = new ArrayList<>();

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //DataSource dataSource = app.getBean(DataSource.class);

        //System.out.println("连接成功"+dataSource.getConnection());
        // 操作数据库
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        jdbcTemplate.query("select * from k_table", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Map<String, String> row = new HashMap();
                row.put("name", resultSet.getString("name"));
                row.put("age", resultSet.getString("age"));
                row.put("birth", resultSet.getString("birth"));
                row.put("shcool", resultSet.getString("shcool"));
                row.put("code", resultSet.getString("code"));
                list.add(row);
            }
        });
        System.out.println(list);
    }

}
