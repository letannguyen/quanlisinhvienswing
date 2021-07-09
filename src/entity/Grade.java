/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Grade implements Serializable{
    private String masv,name;
    private double anh, tin, gdtc;

    public Grade() {
    }

    public Grade(String masv, String name, double anh, double tin, double gdtc) {
        this.masv = masv;
        this.name = name;
        this.anh = anh;
        this.tin = tin;
        this.gdtc = gdtc;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnh() {
        return anh;
    }

    public void setAnh(double anh) {
        this.anh = anh;
    }

    public double getTin() {
        return tin;
    }

    public void setTin(double tin) {
        this.tin = tin;
    }

    public double getGdtc() {
        return gdtc;
    }

    public void setGdtc(double gdtc) {
        this.gdtc = gdtc;
    }
    
}
