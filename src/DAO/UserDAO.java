/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import views.QuanLyDiemSV;
import views.QuanLySV;

/**
 *
 * @author Administrator
 */
public class UserDAO {
    public Users checkLogin(String u,String p, DBConnect db){
        Users kq = new Users();
        try {
            String sql = "SELECT * FROM users\n" + "WHERE username = ? and password = ?";
                PreparedStatement ps = db.getConnect().prepareStatement(sql);
                ps.setString(1, u);
                ps.setString(2, p);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    kq.setUsers(rs.getString(1));
                    kq.setPasswword(rs.getString(2));
                    kq.setRole(rs.getString(3)) ;
                 
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
}
