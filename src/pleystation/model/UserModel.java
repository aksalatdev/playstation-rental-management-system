/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model;

/**
 *
 * @author Aksal
 */
public class UserModel implements IDataModel {
    private final String username;
    private final String fullname;
    private final String password;
    private final UserLevel level;

    public UserModel(String username, String fullname, String password, UserLevel level) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public UserLevel getLevel() {
        return level;
    }

    @Override
    public Object[] toObjects() {
        return new Object[] {username, fullname, level.toString()};
    }
    
    public enum UserLevel {
        Admin, Kasir
    }
}
