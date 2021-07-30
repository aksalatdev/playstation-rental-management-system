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
public class ProductModel implements IDataModel {
    private final int product_id;
    private final String name;
    private final int availability;
    private final int rent_price;
    private final ProductCategory category;

    public ProductModel(int product_id, String name, int availability, int rent_price, ProductCategory category) {
        this.product_id = product_id;
        this.name = name;
        this.availability = availability;
        this.rent_price = rent_price;
        this.category = category;
    }

    public int getProductId() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public int getAvailability() {
        return availability;
    }

    public int getRentPrice() {
        return rent_price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public Object[] toObjects() {
        return new Object[] {product_id, category, name, availability, rent_price};
    }
    
    public enum ProductCategory {
        PLAYSTATION, GAME, ACCESSORIES
    }
}
