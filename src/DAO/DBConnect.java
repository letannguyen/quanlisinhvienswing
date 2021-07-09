/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBConnect {
    Connection connect;
    String url;
    String userName;
    String pass;
    public DBConnect(){
        url = "jdbc:mysql://localhost:3306/fpl_daotao";
        userName = "root";
        pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url,userName,pass);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnec(Connection connect) {
        this.connect = connect;
    }


    void disconnect(){
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
