/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aksal
 */
public class TransactionModel {
    private final int transaction_id;
    private final String user_id;
    private final int customer_id;
    private final Date rent_date;
    private final int duration;
    private final Date return_date;
    private final List<TransactionDetailModel> details;

    public TransactionModel(int transaction_id, String user_id, int customer_id, Date rent_date, int duration, Date return_date) {
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.customer_id = customer_id;
        this.rent_date = rent_date;
        this.duration = duration;
        this.return_date = return_date;
        this.details = new ArrayList<>();
    }

    public int getTransactionId() {
        return transaction_id;
    }

    public String getUsername() {
        return user_id;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public Date getRentDate() {
        return rent_date;
    }

    public Date getReturnDate() {
        return return_date;
    }

    public int getDuration() {
        return duration;
    }

    public List<TransactionDetailModel> getDetails() {
        return details;
    }
}
