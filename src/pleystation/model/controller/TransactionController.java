/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pleystation.model.CustomerModel;
import pleystation.model.TransactionDetailModel;
import pleystation.model.TransactionModel;

/**
 *
 * @author Aksal
 */
public class TransactionController extends DBConnection {
    SimpleDateFormat sqlDate = new SimpleDateFormat("yyyy-MM-dd");

    public boolean addNewRent(TransactionModel transactionModel) {
        boolean status = false;
        
        PreparedStatement pstatement1 = null;
        PreparedStatement pstatement2 = null;
        
        try {
            getConnection().setAutoCommit(false);
            
            String query = "SELECT COUNT(*) FROM transactions WHERE " +
                    "id_pelanggan=? AND tanggal_kembali IS NULL";
            
            statement = getConnection().prepareStatement(query);
            statement.setInt(1, transactionModel.getCustomerId());
            
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt(1) > 0) {
                    return false;
                }
            }
            
            query = "INSERT INTO transactions VALUES (NULL, ?, ?, ?, ?, NULL)";
            statement = getConnection().prepareStatement(query, RETURN_GENERATED_KEYS);
            statement.setString(1, transactionModel.getUsername());
            statement.setInt(2, transactionModel.getCustomerId());
            statement.setString(3, sqlDate.format(transactionModel.getRentDate()));
            statement.setInt(4, transactionModel.getDuration());
            
            statement.executeUpdate();
            
            resultSet = statement.getGeneratedKeys();
            int lastInsertId = 0;
            if (resultSet.next()) {
                lastInsertId = resultSet.getInt(1);
            }

            query = "INSERT INTO transaction_details VALUES (NULL, ?, ?, ?)";
            pstatement1 = getConnection().prepareStatement(query);
            pstatement1.setInt(1, lastInsertId);

            query = "UPDATE products SET ketersediaan=ketersediaan-? WHERE id_barang=?";
            pstatement2 = getConnection().prepareStatement(query);
            for (TransactionDetailModel detail : transactionModel.getDetails()) {
                try {
                    pstatement1.setInt(2, detail.getProductId());
                    pstatement1.setInt(3, detail.getQuantity());
                    pstatement2.setInt(1, detail.getQuantity());
                    pstatement2.setInt(2, detail.getProductId());
                    pstatement1.executeUpdate();
                    pstatement2.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }
            }
            
            getConnection().commit();
            getConnection().setAutoCommit(true);
            status = true;
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            
            try {
                if (pstatement1 != null)
                    pstatement1.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            
            try {
                if (pstatement2 != null)
                    pstatement2.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            
            try {
                resultSet.close();
            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        
        return status;
    }
    
    public List<CustomerModel> getTenants() {
        List<CustomerModel> data = new ArrayList<>();
        
        try {
            String query = "SELECT members.* FROM members INNER JOIN transactions" +
                    " ON members.id_pelanggan=transactions.id_pelanggan WHERE " +
                    " tanggal_kembali IS NULL";
            
            statement = getConnection().prepareStatement(query);
            
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
    
    public TransactionModel getRentDetail(CustomerModel customer) {
        TransactionModel transactionData = null;
        
        try {
            String query = "SELECT * FROM transactions WHERE id_pelanggan=? AND" +
                    " tanggal_kembali IS NULL LIMIT 1";
            
            statement = getConnection().prepareStatement(query);
            statement.setInt(1, customer.getCustomerId());
            
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                transactionData = new TransactionModel(resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getInt(3), 
                        sqlDate.parse(resultSet.getString(4)), 
                        resultSet.getInt(5), null
                );
            }
            
            query = "SELECT * FROM transaction_details WHERE id_transaksi=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setInt(1, transactionData.getTransactionId());
            
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                transactionData.getDetails()
                        .add(new TransactionDetailModel(resultSet.getInt(1), 
                                resultSet.getInt(2), 
                                resultSet.getInt(3), 
                                resultSet.getInt(4))
                        );
            }
        } catch (SQLException | ParseException ex) {
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
        
        return transactionData;
    }
    
    public boolean returnRent(TransactionModel transactionModel) {
        boolean status = false;
        
        try {
            getConnection().setAutoCommit(false);
            String query = "UPDATE transactions SET tanggal_kembali=? WHERE id_transaksi=?";
            
            statement = getConnection().prepareStatement(query);
            statement.setString(1, sqlDate.format(new Date()));
            statement.setInt(2, transactionModel.getTransactionId());
            
            statement.executeUpdate();
            
            query = "UPDATE products SET ketersediaan=ketersediaan+? WHERE id_barang=?";
            statement = getConnection().prepareStatement(query);
            
            for (TransactionDetailModel detail : transactionModel.getDetails()) {
                statement.setInt(1, detail.getQuantity());
                statement.setInt(2, detail.getProductId());
                statement.executeUpdate();
            }
            
            getConnection().commit();
            getConnection().setAutoCommit(true);
            status = true;
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
}
