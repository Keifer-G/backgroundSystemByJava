package com.keifer.web;

import com.keifer.Base.Adminer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/go")
public class HomeController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/home")
    @ResponseBody
    public String getHome(){
        final List<Object> list = new ArrayList<>();
        /*
        *      切记！！！
        *           各种配置要弄清！
        *           配置要配全！！！
        *      配置如下：
        *           1.applicationContext:
        *               jdbc:
        *                   1.application.properties
        *                   2.dataSource BEAN
        *                   3.jdbcTemplate BEAN
        *           2.spring-mvc:
        *               1.自动扫描
        *               2.数据驱动
        *           3.web:
        *               1.全局初始化配置applicationContext.xml
        *               2.DispatcherServlet
        *               3.其他 : fitler、listner...
        *           4.mysql
        *               别忘了启动数据库!!!!!!!!
        *               别忘了启动数据库!!!!!!!!
        *               别忘了启动数据库!!!!!!!!
         */
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
        System.out.println("home");
        return list.toString();
    }


    @RequestMapping("/sqlData")
    @ResponseBody
    public String getSqlData() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("adminerMapConfig.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sessionFactory.openSession();

        List<Adminer> list = session.selectList("adminerMapper.findAll");

        for(Adminer a : list){
            System.out.println(a);
        }

        session.close();

        return list.toString();
    }
}
