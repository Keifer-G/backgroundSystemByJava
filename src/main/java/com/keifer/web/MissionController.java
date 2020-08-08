package com.keifer.web;

import com.keifer.Base.Message;
import com.keifer.Base.Mission;
import com.keifer.Dao.MissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class MissionController {

    @Autowired
    private MissionDao missionDao;

    /*
        推送任务
        param : Map
        result : map missioncode
     */
    @RequestMapping(value = "/sendmission", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> sendMission(@RequestBody HashMap<String,Object> object){
        Map<String,Object> result = new HashMap<>();
        try {
            int key;
            List<Mission> missions = missionDao.findAll();
            key = missions.size();
            long now = new Date().getTime();
            java.sql.Date sqlNow = new java.sql.Date(now);
            Mission newMission = new Mission();
            newMission.setId(UUID.randomUUID().toString());
            newMission.setMission((String) object.get("mission"));
            newMission.setKey(String.valueOf(key));
            newMission.setTime(sqlNow);
            newMission.setErvery(true);
            Integer add = missionDao.add(newMission);
            System.out.println(add);
            if(add==1){
                result.put("missioncode",1);
            }else {
                result.put("missioncode",0);
            }
        }catch (Exception e){
            result.put("missioncode",0);
        }
        return result;
    }

    /*
        返回任务
        param : Mission
        result : map missioncode
     */
    @RequestMapping(value = "/mission", method = RequestMethod.POST)
    @ResponseBody
    public List<Mission> getMission(@RequestBody Mission mission){
        List<Mission> missions = missionDao.getMisiion(mission);
        return missions;
    }

    @RequestMapping(value = "/currentmission", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getCurrentMission(@RequestBody HashMap<String,Object> object){
        Map<String,Object> result = new HashMap<>();
        try {
            int key;
            List<Mission> missions = missionDao.findAll();
            key = missions.size();
            long now = new Date().getTime();
            java.sql.Date sqlNow = new java.sql.Date(now);
            Mission newMission = new Mission();
            newMission.setId(UUID.randomUUID().toString());
            Map<String,Object> values = (HashMap<String, Object>) object.get("values");
            newMission.setMission((String) values.get("mission"));
            newMission.setKey(String.valueOf(key));
            newMission.setTime(sqlNow);
            newMission.setErvery(false);
            newMission.setUsername((String) object.get("username"));
            newMission.setId(UUID.randomUUID().toString());
            Integer add = missionDao.add(newMission);
            if(add==1){
                result.put("missioncode",1);
            }else {
                result.put("missioncode",0);
            }
        }catch (Exception e){
            result.put("missioncode",0);
        }
        return result;
    }
}
