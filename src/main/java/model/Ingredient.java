package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "ingredients")
public class Ingredient extends NamedEntity {

    @Column (name = "price")
    @NotEmpty
    private int price;

    @Column (name = "available")
    private boolean available;

    @Column (name = "quantity")
    private String quantity;

    public Ingredient(){}

    public Ingredient(int id, String name, int price, boolean available) {
        super(id, name);
        this.available = available;
        this.price = price;
    }

    public Ingredient(Ingredient ingredient) {
        this(ingredient.getId(), ingredient.getName(), ingredient.getPrice(), ingredient.available);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
