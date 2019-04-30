/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.command;

import com.mnzit.terminalchatapplication.handler.BroadCaster;
import java.io.IOException;

/**
 *
 * @author Mnzit
 */
public class ExitCommand extends Command {

    @Override
    public void execute(String[] tokens) {
        String message = client.getUser().getUserName() + " left the lobby";
        try {
            BroadCaster.broadcastAll(message, clientHandler, client);
            clientHandler.remove(client);
            client.getSocket().close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
