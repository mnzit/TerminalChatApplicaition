/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.handler;

import com.mnzit.terminalchatapplication.entity.User;
import java.net.Socket;

/**
 *
 * @author Mnzit
 */
public class Client {
    private Socket socket;
    private User user;

    public Client() {
    }

    public Client(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public Client setSocket(Socket socket) {
        this.socket = socket;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Client setUser(User user) {
        this.user = user;
        return this;
    }
}
