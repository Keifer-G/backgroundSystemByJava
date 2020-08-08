package com.keifer.web;

import com.keifer.Base.Adminer;
import com.keifer.Base.Message;
import com.keifer.Dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class MessageController {

    @Autowired
    private MessageDao messageDao;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getMessage(){
        List<Message> all = messageDao.findAll();
        return all;
    }

    /*
        上传广播信息
     */
    @RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> sendMessage(@RequestBody HashMap<String,Object> object){
        Map<String,Object> result = new HashMap<>();
        try {
            int key;
            List<Message> messages = messageDao.findAll();
            key = messages.size() + 1;
            long now = new Date().getTime();
            java.sql.Date sqlNow = new java.sql.Date(now);
            Message newMessage = new Message();
            newMessage.setId(UUID.randomUUID().toString());
            newMessage.setContent((String) object.get("message"));
            newMessage.setKey(String.valueOf(key));
            newMessage.setTime(sqlNow);
            Integer add = messageDao.add(newMessage);
            if(add==1){
                result.put("messagecode",1);
            }else {
                result.put("messagecode",0);
            }
        }catch (Exception e){
            result.put("messagecode",0);
        }
        return result;
    }
}
