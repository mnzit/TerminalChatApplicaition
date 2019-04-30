/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.command;

import com.mnzit.terminalchatapplication.handler.Client;

/**
 *
 * @author Mnzit
 */
public class ListCommand extends Command {

    @Override
    public void execute(String[] tokens) {
        for (Client c : clientHandler.getAll()) {
            out.println(c.getUser().getId()+". "+c.getUser().getUserName());
        }
    }

}
