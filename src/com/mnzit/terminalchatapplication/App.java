/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication;

import com.mnzit.terminalchatapplication.handler.ClientHandler;
import com.mnzit.terminalchatapplication.handler.RequestHandler;
import com.mnzit.terminalchatapplication.service.UserService;
import com.mnzit.terminalchatapplication.service.UserServiceDBImpl;
import com.mnzit.terminalchatapplication.service.impl.UserServiceImpl;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mnzit
 */
public class App {
    
    public static void main(String[] args) {
        int port = 9000;
        int ids = 1;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running at: " + port);
            UserService service = new UserServiceDBImpl();
            ClientHandler clienthandler = new ClientHandler();
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection from " + socket.getInetAddress().getHostAddress());
                RequestHandler handler = new RequestHandler(socket);
                handler.setService(service);
                handler.setHandler(clienthandler);
                handler.setIds(ids++);
                handler.start();                
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
