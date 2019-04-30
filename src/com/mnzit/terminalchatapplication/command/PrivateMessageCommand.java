/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.command;

import com.mnzit.terminalchatapplication.handler.BroadCaster;
import com.mnzit.terminalchatapplication.handler.Client;
import java.io.IOException;

/**
 *
 * @author Mnzit
 */
public class PrivateMessageCommand extends Command {

    @Override
    public void execute(String[] tokens) {
        Client c = clientHandler.getClientByName(tokens[1]);
        try {
            if (client != null) {
                BroadCaster.broadcastOne(client.getUser().getUserName() + " -> " + tokens[2], c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
