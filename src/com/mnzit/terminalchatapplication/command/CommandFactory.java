/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.command;

/**
 *
 * @author Mnzit
 */
public class CommandFactory {

    public static Command getCommand(String param) {
        if (param.equalsIgnoreCase("list")) {
            return new ListCommand();
        } else if (param.equalsIgnoreCase("pm")) {
            return new PrivateMessageCommand();
        } else if (param.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        } else {
            return null;
        }
    }
}
