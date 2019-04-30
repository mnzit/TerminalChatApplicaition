/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.service.impl;

import com.mnzit.terminalchatapplication.entity.User;
import com.mnzit.terminalchatapplication.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class UserServiceImpl implements UserService {

    List<User> user = new ArrayList<>();

    @Override
    public User login(String username, String password) {
        for (User user1 : user) {
            if(user1.getUserName().equals(username) && user1.getPassword().equals(password)){
               return user1; 
            }
        }
        return null;
    }

    @Override
    public void register(String username, String password,int ids) {
        user.add(new User(ids, username, password, new Date(), true, 100));
    }

}
