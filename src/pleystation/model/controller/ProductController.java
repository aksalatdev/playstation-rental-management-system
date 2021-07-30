/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pleystation.model.ProductModel;
import pleystation.model.ProductModel.ProductCategory;

/**
 *
 * @author Aksal
 */
public class ProductController extends IDataController<ProductModel> {

    @Override
    public boolean addData(ProductModel dataModel) {
        boolean status = false;
        
        try {
            String query = "INSERT INTO products VALUES(NULL, ?, ?, ?, ?)";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, dataModel.getCategory().toString());
            statement.setString(2, dataModel.getName());
            statement.setInt(3, dataModel.getAvailability());
            statement.setInt(4, dataModel.getRentPrice());
            
            status = statement.executeUpdate(query) > 0;
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
    public boolean updateData(ProductModel dataModel) {
        boolean status = false;
        
        try {
            String query = "UPDATE products SET kategori=?, nama=?, " +
                    "ketersediaan=?, harga_sewa=? WHERE id_barang=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, dataModel.getCategory().toString());
            statement.setString(2, dataModel.getName());
            statement.setInt(3, dataModel.getAvailability());
            statement.setInt(4, dataModel.getRentPrice());
            statement.setInt(5, dataModel.getProductId());
            
            status = statement.executeUpdate(query) > 0;
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
            String query = "DELETE FROM products WHERE id_barang=?";
            
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
    public ProductModel getData(int id) {
        String query = "SELECT * FROM products WHERE id_barang=? LIMIT 1";
        List<ProductModel> data = getData(1, query, id);
        if(data.isEmpty()) {
            return null;
        } else {
            return data.get(0);
        }
    }

    @Override
    public List<ProductModel> getAllData(int page) {
        return getData(page, "SELECT * FROM products");
    }
    
    @Override
    public List<ProductModel> searchData(String query, int page) {
        String _query = "SELECT * FROM products WHERE kategori LIKE ? OR nama LIKE ?";
        query = "%" + query + "%";
        
        return getData(page, _query, query, query);
    }
    
    private List<ProductModel> getData(int page, String query, Object... params) {
        List<ProductModel> data = new ArrayList<>();
        
        try {
            statement = getConnection().prepareStatement(query);
            for (int i = 0; i < params.length; ++i) {
                statement.setObject(i+1, params[i]);
            }
            
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                data.add(new ProductModel(resultSet.getInt(1), 
                        resultSet.getString(3), 
                        resultSet.getInt(4), 
                        resultSet.getInt(5),
                        ProductCategory.valueOf(resultSet.getString(2)))
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
