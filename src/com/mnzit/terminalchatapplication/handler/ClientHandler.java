/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.handler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class ClientHandler {

    List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getAll() {
        return clients;
    }

    public Client getClientByName(String name) {
        for (Client client : clients) {
            if (client.getUser().getUserName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }
    

    public boolean remove(Client client) {
        return clients.remove(client);
    }

}
