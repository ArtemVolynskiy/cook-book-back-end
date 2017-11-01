package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
@Table (name = "ingredients")
@NamedQueries({
        @NamedQuery(name = Ingredient.DELETE, query = "DELETE FROM Ingredient i WHERE i.id=:id"),
        @NamedQuery(name = Ingredient.GET_ALL, query = "SELECT i FROM Ingredient i ORDER BY i.name"),
        @NamedQuery(name = Ingredient.FIND, query = "SELECT i FROM Ingredient i WHERE i.name=:name")
}
)
public class Ingredient extends NamedEntity {
    public static final String DELETE = "Ingredient.delete";
    public static final String FIND = "Ingredient.find";
    public static final String GET_ALL = "Ingredient.all";

    @Column (name = "price")
    @NotNull
    private int price;

    @Column (name = "available")
    private boolean available = true;


    @Column (name = "quantity")
    private int quantity;


    public Ingredient(){}

    private Ingredient(int id, String name, int price, boolean available) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "id: " + this.getId() + "\n"
                + "name: " + this.getName() + "\n"
                + "price: " + this.getPrice() + "\n"
                + "available: " + this.isAvailable() + "\n"
                + "quantity: " + this.getQuantity();
    }
}
