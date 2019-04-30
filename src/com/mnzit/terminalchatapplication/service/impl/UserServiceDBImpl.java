/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.service.impl;

import com.mnzit.terminalchatapplication.entity.User;
import com.mnzit.terminalchatapplication.repository.UserRepository;
import com.mnzit.terminalchatapplication.repository.UserRepositoryImpl;
import com.mnzit.terminalchatapplication.service.UserService;

/**
 *
 * @author Mnzit
 */
public class UserServiceDBImpl implements UserService{
    
    UserRepository repository = new UserRepositoryImpl();
    @Override
    public User login(String username, String password) throws Exception{
        return repository.login(username, password);
    }

    @Override
    public void register(String username, String password, int ids) throws Exception {
        repository.add(username, password, ids);
    }
    
}
