/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.service;

import com.mnzit.terminalchatapplication.entity.User;

/**
 *
 * @author Mnzit
 */
public interface UserService {

    User login(String username, String password) throws Exception;

    void register(String username, String password, int ids) throws Exception;
}
