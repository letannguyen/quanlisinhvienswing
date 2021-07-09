/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Administrator
 */
public class Users {
    private String users;
    private String passwword;
    private String role;

    public Users() {
    }

    public Users(String users, String passwword, String role) {
        this.users = users;
        this.passwword = passwword;
        this.role = role;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
