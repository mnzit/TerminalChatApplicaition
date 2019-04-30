/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.handler;

import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Mnzit
 */
public class BroadCaster {

    public static void broadcastAll(String message, ClientHandler handler, Client client) throws IOException {
        for (Client c : handler.getAll()) {
            if (!c.equals(client)) {
                PrintStream outi = new PrintStream(c.getSocket().getOutputStream());
                outi.println(message);
            }
        }
    }

    public static void broadcastOne(String message, Client client) throws IOException {
        PrintStream outi = new PrintStream(client.getSocket().getOutputStream());
        outi.println(message);
    }
}
