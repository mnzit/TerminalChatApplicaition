/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.terminalchatapplication.repository;

import com.mnzit.terminalchatapplication.entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mnzit
 */
public class UserRepositoryImpl implements UserRepository {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/terminal", "root", "");
        return conn;
    }

    @Override
    public User login(String username, String password) throws Exception {
        PreparedStatement pstm = getConnection().prepareStatement("SELECT * from user WHERE username=? AND password=?");
        pstm.setString(1, username);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("username"));
            user.setJoinDate(rs.getDate("join_date"));
            user.setStatus(rs.getBoolean("status"));
            user.setBalance(rs.getInt("balance"));
            return user;
        }
        return null;
    }

    @Override
    public void add(String username, String password, int ids) throws Exception {
        PreparedStatement pstm = getConnection().prepareStatement("INSERT INTO user(username,password,balance) VALUES(?,?,100)");
        pstm.setString(1, username);
        pstm.setString(2, password);
        pstm.executeUpdate();
    }

}
