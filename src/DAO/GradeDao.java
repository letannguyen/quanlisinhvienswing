/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entity.Students;
import entity.Grade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeDao {
    public ArrayList<Grade> getListGrade(DBConnect db){
        ArrayList<Grade> kq = new ArrayList<>();
        try {
            String sql = "SELECT a.MASV,a.Hoten,TiengAnh,TinHoc,GDTC from student a inner join grade b on a.MASV = b.MASV";
            PreparedStatement ps = db.getConnect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Grade g = new Grade();
                g.setMasv(rs.getString(1));
                g.setName(rs.getString(2));
                g.setAnh(rs.getDouble(3));
                g.setTin(rs.getDouble(4));
                g.setGdtc(rs.getDouble(5));
                kq.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    
    public int saveGrade(DBConnect db,Grade gra){
        int kq = -1;
        try {
            String sql = "insert into grade(MASV, TiengAnh, TinHoc, GDTC) values ( ?, ?, ?, ?)";
            PreparedStatement ps = db.getConnect().prepareStatement(sql);
            ps.setString(1, gra.getMasv());
            ps.setDouble(2, gra.getAnh());
            ps.setDouble(3, gra.getTin());
            ps.setDouble(4, gra.getGdtc());
            kq = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    
    public int updateGrade(DBConnect db,Grade g){
        int kq = -1;
        try {
            String sql = "update grade set TiengAnh = ?, TinHoc = ?, GDTC = ? where MASV = ? ";
            PreparedStatement ps = db.getConnect().prepareStatement(sql);
            ps.setDouble(1, g.getAnh());
            ps.setDouble(2, g.getTin());
            ps.setDouble(3, g.getGdtc());
            ps.setString(4, g.getMasv());
            kq = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    
    public int deleteDiemGrade(DBConnect db , String ID){
        int kq = -1;
        try {
            String sql = "UPDATE grade SET TiengAnh = null, TinHoc = null, GDTC = null WHERE MASV = ?";
            PreparedStatement ps = db.getConnect().prepareStatement(sql);
            ps.setString(1, ID);
            kq = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
    
        
}
