/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pleystation.model.CustomerModel;

/**
 *
 * @author Aksal
 */
public class CustomerController extends IDataController<CustomerModel> {

    @Override
    public boolean addData(CustomerModel dataModel) {
        boolean status = false;
        
        try {
            String query = "INSERT INTO members VALUES(NULL, ?, ?, ?))";
            query = query.replace("%nama%", dataModel.getName());
            query = query.replace("%alamat%", dataModel.getAddress());
            query = query.replace("%telpon%", dataModel.getTelephone());
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, dataModel.getName());
            statement.setString(2, dataModel.getAddress());
            statement.setString(3, dataModel.getTelephone());
            
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
    public boolean updateData(CustomerModel dataModel) {
        boolean status = false;
        
        try {
            String query = "UPDATE members SET nama=?, alamat=?" + 
                    ", no_telpon=? WHERE id_pelanggan=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, dataModel.getName());
            statement.setString(2, dataModel.getAddress());
            statement.setString(3, dataModel.getTelephone());
            statement.setInt(4, dataModel.getCustomerId());
            
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
        boolean status = false;
        
        try {
            String query = "DELETE FROM members WHERE id_pelanggan=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            
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
    public CustomerModel getData(int id) {
        String query = "SELECT * FROM members WHERE id_pelanggan=? LIMIT 1";
        
        List<CustomerModel> data = getData(1, query, id);
        if(data.isEmpty()) {
            return null;
        } else {
            return data.get(0);
        }
    }

    @Override
    public List<CustomerModel> getAllData(int page) {
        return getData(page, "SELECT * FROM members");
    }
    
    @Override
    public List<CustomerModel> searchData(String query, int page) {
        String _query = "SELECT * FROM members WHERE id_pelanggan LIKE ? " +
                "OR nama LIKE ? OR alamat LIKE ? OR no_telpon LIKE ?";
        query = "%" + query + "%";
        
        return getData(page, _query, query, query, query, query);
    }
    
    public boolean isRenting(int id) {
        boolean renting = false;
        
        try {
            String query = "SELECT IF(MAX(1)=1, 1, 0) FROM transactions WHERE " + 
                    "tanggal_kembali IS NULL AND id_pelanggan=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                renting = resultSet.getInt(1) == 1;
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
                resultSet.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return renting;
    }
    
    private List<CustomerModel> getData(int page, String query, Object... params) {
        List<CustomerModel> data = new ArrayList<>();
        
        try {
            statement = getConnection().prepareStatement(query);
            for (int i = 0; i < params.length; ++i) {
                statement.setObject(i+1, params[i]);
            }
            
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                data.add(new CustomerModel(resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(4), 
                        resultSet.getString(3))
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
                resultSet.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return data;
    }
    
}
