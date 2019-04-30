/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.command;

import com.mnzit.terminalchatapplication.handler.Client;
import com.mnzit.terminalchatapplication.handler.ClientHandler;
import java.io.BufferedReader;
import java.io.PrintStream;

/**
 *
 * @author Mnzit
 */
public abstract class Command {
    
    protected Client client = null;
    protected ClientHandler clientHandler = null;
    protected PrintStream out = null;
    protected BufferedReader reader = null;
    
    public void initilize(Client client, ClientHandler clientHandler, PrintStream out, BufferedReader reader){
        this.client = client;
        this.clientHandler = clientHandler;
        this.out = out;
        this.reader = reader;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setClientHandler(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
    
    public abstract void execute(String[] tokens);
}
