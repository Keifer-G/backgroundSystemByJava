package com.keifer.web;

import com.keifer.Base.Message;
import com.keifer.Base.User;
import com.keifer.Dao.MessageDao;
import com.keifer.Dao.MissionDao;
import com.keifer.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private MissionDao missionDao;

    /*
        用户登录
        param : username password
        result : User
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(@RequestBody User user){
        User userInfo = userDao.userLogin(user);

        System.out.println(userInfo);
        Map<String,Object> result = new HashMap<>();
        if(userInfo==null) {
            result.put("logincode", 0);
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("loginState",userInfo);
            result.put("logincode",1);
            result.put("data",map);
        }
        return result;
    }

    /*
        获取所有的管理员
        param :
        result : List<User>
     */
    @RequestMapping("/adminers")
    @ResponseBody
    public List<User> getAdminers(){
        List<User> adminerData = userDao.getAdminerData();
        return adminerData;
    }

    /*
        新增保存用户
        param : User
        result Map addcode
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        User oldUser = userDao.findByUsername(user);
        if(oldUser==null){
            List<User> all = userDao.findAll();
            user.setId(UUID.randomUUID().toString());
            user.setUserCompony(user.getCompony());
            user.setUsersex(user.getSex());
            user.setLevel(1);
            user.setKey(String.valueOf(all.size()));
            user.setUseremail(user.getEmail());
            user.setAge(0);
            userDao.add(user);
            result.put("addcode",1);
        }else{
            result.put("addcode",0);
        }
        return result;
    }

    /*
        删除用户
        param : User
        result Map deletecode
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        User oldUser = userDao.findByUsername(user);
        Integer delete = userDao.delete(oldUser.getId());
        if(delete == 1){
            result.put("deletecode",1);
        }else {
            result.put("deletecode",0);
        }
        return result;
    }

    /*
        上传头像
        param : Map
        result Map uploadcode
    */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteUser(@RequestBody HashMap<String,Object> object) throws Exception {
        Map<String,Object> result = new HashMap<>();
        if(object.get("imageUri")!=null){
            User user = new User();
            user.setUsername((String) object.get("username"));
            User user1 = userDao.findByUsername(user);
            if (user1!=null){
                user1.setUseruri((String) object.get("imageUri"));
                Integer update = userDao.update(user1);
                if(update==1){
                    result.put("uploadcode",1);
                }else {
                    throw new Exception("头像上传失败！");
                }
            }else{
                result.put("uploadcode",0);
            }
        }else {
            result.put("uploadcode",0);
        }
        return result;
    }

    /*
        请求当前用户
        param : User
        result User
    */
    @RequestMapping(value = "/currentuser", method = RequestMethod.POST)
    @ResponseBody
    public User getCurrentUser(@RequestBody HashMap<String,Object> objectHashMap) {
        User th = new User();
        th.setUsername((String) objectHashMap.get("username"));
        User user1 = userDao.findByUsername(th);
        System.out.println(user1);
        return user1;
    }

    /*
        更新保存用户信息
        param : User
        result User
    */
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateUser(@RequestBody HashMap<String,Object> object) {
        Map<String,Object> result = new HashMap<>();
        HashMap<String,Object> mew = (HashMap<String, Object>) object.get("values");
        User newUser = new User();
        newUser.setPassword((String) mew.get("password"));
        newUser.setUsersex((String) mew.get("sex"));
        newUser.setLevel(1);
        newUser.setUserCompony((String) mew.get("compony"));
        newUser.setUseremail((String) mew.get("email"));
        newUser.setUsernum((Integer) mew.get("usernum"));
        newUser.setAge((Integer) mew.get("age"));
        newUser.setUserInfp((String) mew.get("plan"));
        newUser.setUsername((String) mew.get("name"));
        newUser.setUserInfo((String) mew.get("selfInfo"));
        User isNewUser = userDao.findByUsername(newUser);
        if(isNewUser == null){
            User oldUsername = new User();
            oldUsername.setUsername((String) object.get("username"));
            User oldUser = userDao.findByUsername(oldUsername);
            newUser.setId(oldUser.getId());
            newUser.setUsername(newUser.getUsername() == "" ? oldUsername.getUsername() : newUser.getUsername());
            newUser.setPassword(newUser.getPassword() == "" ? oldUser.getPassword() : newUser.getPassword());
            newUser.setUsersex(newUser.getUsersex() == "" ? oldUser.getUsersex() : newUser.getUsersex());
            newUser.setKey(oldUser.getKey());
            newUser.setUserCompony(newUser.getUserCompony() == "" ? oldUser.getUserCompony() : newUser.getUserCompony());
            newUser.setUseremail(newUser.getUseremail() == "" ? oldUser.getUseremail() : "www." + newUser.getUseremail() + ".com");
            newUser.setUsernum(newUser.getUsernum() != null ? newUser.getUsernum() : oldUser.getUsernum());
            newUser.setAge(newUser.getAge() != null ? newUser.getAge() : oldUser.getAge());
            newUser.setUserInfp(newUser.getUserInfp() == "" ? oldUser.getUserInfp() : newUser.getUserInfp());
            newUser.setUseruri(oldUser.getUseruri());
            newUser.setUserInfo(newUser.getUserInfo() == "" ? oldUser.getUserInfo() : newUser.getUserInfo());
            Integer update = userDao.update(newUser);
            if(update==1){
                result.put("changecode",1);
            }else {
                result.put("changecode",0);
            }
        }else {
            result.put("changecode",0);
        }
        return result;
    }


}
