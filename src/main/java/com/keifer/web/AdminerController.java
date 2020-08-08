package com.keifer.web;

import com.keifer.Base.Adminer;
import com.keifer.Dao.AdminerDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/adminer")
public class AdminerController {

/*
    public SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("adminerMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
*/
    @Autowired
    private AdminerDao mapper;

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() throws IOException {
/*        SqlSession sqlSession = getSqlSession();
        AdminerDao mapper =  sqlSession.getMapper(AdminerDao.class);*/
        List<Adminer> adminers = mapper.findAll();
        for (Adminer adminer1 : adminers) {
            System.out.println(adminer1);
        }
        return adminers.toString();
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne() throws IOException {
        Adminer adminer = mapper.findOne("b89232a9-5008-492e-903e-a9152864dc35");
        System.out.println(adminer);
        return adminer.toString();
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() throws IOException {
        Adminer newAdminer = new Adminer();
        newAdminer.setId(UUID.randomUUID().toString());
        newAdminer.setName("test");
        newAdminer.setAge("100");
        newAdminer.setCode("9802161112");
        newAdminer.setShcool("SUNHE PRIMARY SCHOOL");
        newAdminer.setBirth("2111-02-16");
        Integer success = mapper.add(newAdminer);
        System.out.println(success);
        return success.toString();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() throws IOException {
        Integer success = mapper.delete("41315d58-05c2-4b7e-874c-8e3e6553e4c1");
        System.out.println(success);
        return success.toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update() throws IOException {
        Adminer one = mapper.findOne("1cabaa7d-3c71-4f7c-98b3-4b5193fdc28b");
        one.setName("gujiawei");
        one.setAge("15");
        one.setShcool("XINGHONG SCHOOL");
        Integer success = mapper.update(one);
        System.out.println(success);
        return success.toString();
    }
}
