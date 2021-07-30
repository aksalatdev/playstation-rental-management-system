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
public class TransactionDetailModel {
    private final int transactiondetail_id;
    private final int transaction_id;
    private final int product_id;
    private final int quantity;

    public TransactionDetailModel(int transactiondetail_id, int transaction_id, int product_id, int quantity) {
        this.transactiondetail_id = transactiondetail_id;
        this.transaction_id = transaction_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getTransactionDetailId() {
        return transactiondetail_id;
    }

    public int getTransactionId() {
        return transaction_id;
    }

    public int getProductId() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }
}
