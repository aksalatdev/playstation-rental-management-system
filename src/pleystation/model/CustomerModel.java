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
public class CustomerModel implements IDataModel {
    private final int customer_id;
    private final String name;
    private final String telephone;
    private final String address;

    public CustomerModel(int customer_id, String name, String telephone, String address) {
        this.customer_id = customer_id;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public Object[] toObjects() {
        return new Object[] {customer_id, name, telephone, address};
    }
}
