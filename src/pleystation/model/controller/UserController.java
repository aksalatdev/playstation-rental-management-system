/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pleystation.model.UserModel;

/**
 *
 * @author Aksal
 */
public class UserController extends IDataController<UserModel> {

    @Override
    public boolean addData(UserModel dataModel) {
        boolean status = false;
        
        try {
            String query = "INSERT INTO users VALUES (?, ?, ?, ?);";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, dataModel.getUsername());
            statement.setString(2, dataModel.getFullname());
            statement.setString(3, dataModel.getPassword());
            statement.setString(4, dataModel.getLevel().toString());
            
            status = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return status;
    }

    @Override
    public boolean updateData(UserModel dataModel) {
        boolean status = false;
        
        try {
            String query = "UPDATE users SET nama=?, password=?," +
                    " hak_akses=? WHERE nama_pengguna=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, dataModel.getFullname());
            statement.setString(2, dataModel.getPassword());
            statement.setString(3, dataModel.getLevel().toString());
            statement.setString(4, dataModel.getUsername());
            
            status = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return status;
    }

    @Override
    public boolean deleteData(int id) {
        return false;
    }
    
    public boolean deleteUserData(String username) {
        boolean status = false;
        try {
            String query = "DELETE FROM users WHERE nama_pengguna=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, username);
            
            status = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return status;
    }

    @Override
    public UserModel getData(int id) {
        return null;
    }
    
    public UserModel getUserData(String username) {
        String _query = "SELECT nama_pengguna, nama, hak_akses FROM users WHERE" +
                " nama_pengguna=?";
        
        List<UserModel> data = getData(1, _query, username);
        if(data.isEmpty()) {
            return null;
        } else {
            return data.get(0);
        }
    }
    
    public UserModel authenticate(String username, String password) {
        String _query = "SELECT nama_pengguna, nama, hak_akses FROM users WHERE" +
                " nama_pengguna=? AND password=?";
        
        List<UserModel> data = getData(1, _query, username, password);
        if(data.isEmpty()) {
            return null;
        } else {
            return data.get(0);
        }
    }

    @Override
    public List<UserModel> getAllData(int page) {
        return getData(page, "SELECT nama_pengguna, nama, hak_akses FROM users");
    }
    
    @Override
    public List<UserModel> searchData(String query, int page) {
        String _query = "SELECT nama_pengguna, nama, hak_akses FROM users WHERE" +
                " nama_pengguna LIKE ? OR nama LIKE ? OR hak_akses LIKE ?";
        query = "%" + query + "%";
        
        return getData(page, _query, query, query, query);
    }
    
    private List<UserModel> getData(int page, String query, Object... params) {
        List<UserModel> data = new ArrayList<>();
        
        try {
            statement = getConnection().prepareStatement(query);
            for (int i = 0; i < params.length; ++i) {
                statement.setObject(i+1, params[i]);
            }
            
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                data.add(new UserModel(resultSet.getString(1), 
                        resultSet.getString(2), "", 
                        UserModel.UserLevel.valueOf(resultSet.getString(3)))
                );
            }
        } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return data;
    }
    
}
