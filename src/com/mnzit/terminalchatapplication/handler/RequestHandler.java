/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.handler;

import com.mnzit.terminalchatapplication.command.Command;
import com.mnzit.terminalchatapplication.command.CommandFactory;
import com.mnzit.terminalchatapplication.entity.User;
import com.mnzit.terminalchatapplication.service.UserService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Mnzit
 */
public class RequestHandler extends Thread {

    private Socket socket = null;
    private PrintStream out = null;
    private BufferedReader reader = null;
    private UserService service = null;
    private int ids = 0;
    private ClientHandler handler = null;

    public RequestHandler(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        while (true) {
            menu();
            try {
                out.println("Enter your choice");
                String value = reader.readLine();
                if (value.equals("1") || value.equals("2")) {
                    out.println("Enter your username");
                    String username = reader.readLine();
                    out.println("Enter your password");
                    String password = reader.readLine();
                    if (value.equals("1")) {
                        service.register(username, password, ids);
                    } else {
                        User user = service.login(username, password);
                        if (user != null) {
                            Client client = new Client(socket, user);
                            BroadCaster.broadcastAll(client.getUser().getUserName() + " joined the lobby", handler, client);
                            handler.addClient(client);
                            out.println("Begin chatting");
                            while (true) {
                                out.println("(me)>");
                                String line = reader.readLine();
                                String[] lines = line.split(";;");
                                Command command = CommandFactory.getCommand(lines[0]);
                                if (command != null) {
                                    command.initilize(client, handler, out, reader);
                                    command.execute(lines);
                                } else {
                                    BroadCaster.broadcastAll(client.getUser().getUserName() + " -> " + line, handler, client);
                                }
                            }
                        } else {
                            out.println("Not registered yet");
                        }
                    }
                } else if (value.equals("3")) {
                    socket.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void menu() {
        out.println("1. Register");
        out.println("2. Login");
    }
}
