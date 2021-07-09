/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.Students;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class StudentDAO {
    public ArrayList<Students> getAllStudents(DBConnect db){
        ArrayList<Students> kq = new ArrayList<>();
        String sql = "select * from student";
        try {
            PreparedStatement ps = db.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Students sv = new Students();
                sv.setIdStudent(rs.getString(1));
                sv.setName(rs.getString(2));
                sv.setEmail(rs.getString(3));
                sv.setPhone(rs.getString(4));
                sv.setGender(rs.getString(5));
                sv.setAddress(rs.getString(6));
                sv.setImage(rs.getString(7));
                kq.add(sv);
            }
            ps.close();rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return kq;
    }
    
    public int saveStudent(DBConnect connec,Students sv){
        String sql = "insert into student values (?,?,?,?,?,?,?)";
        int r = 0;
        try {
            PreparedStatement ps = connec.getConnect().prepareStatement(sql);
            ps.setString(1, sv.getIdStudent());
            ps.setString(2, sv.getName());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getPhone());
            ps.setString(5, sv.getGender());
            ps.setString(6, sv.getAddress());
            ps.setString(7,sv.getImage());  
            
            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public int updateStudent(DBConnect connec,Students sv){
        String sql = "update student set Hoten = ?,Email = ?,soDT = ?,Gioitinh = ?,Diachi = ?,Hinh = ? where MASV = ?";
        int r = 0;
        try {
            PreparedStatement ps = connec.getConnect().prepareStatement(sql);
            
            ps.setString(1, sv.getName());
            ps.setString(2, sv.getEmail());
            ps.setString(3, sv.getPhone());
            ps.setString(4, sv.getGender());
            ps.setString(5, sv.getAddress());
            ps.setString(6, sv.getImage());
            ps.setString(7, sv.getIdStudent());
            r = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public int deleteStudent(DBConnect connec,String stuID){
        String sql = "delete from student where MASV = ?";
        int r = 0;
        try {
            PreparedStatement ps = connec.getConnect().prepareStatement(sql);
            ps.setString(1, stuID);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
}
