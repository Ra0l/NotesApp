package com.raul.notesapp.repositories;

import com.orm.SugarRecord;
import com.raul.notesapp.models.User;

import java.util.List;

public class UserRepository {

    public static void create(String username,String fullname,String email,String password){
        User user=new User();
        user.setUser(username);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);

        SugarRecord.save(user);
    }

    public static User login(String user, String password){

        List<User> users = SugarRecord.find(User.class,
                "user=? and password=?", user, password);

        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
    public static User load (Long id){
        User user = SugarRecord.findById(User.class,id);
        return user;
    }
}
