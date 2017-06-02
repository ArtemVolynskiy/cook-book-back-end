package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table (name = "ingredients")
@NamedQueries({
        @NamedQuery(name = Ingredient.DELETE, query = "DELETE FROM Ingredient i WHERE i.name=:name"),
        @NamedQuery(name = Ingredient.GET_ALL, query = "SELECT i FROM Ingredient i ORDER BY i.name")
}
)
public class Ingredient extends NamedEntity {
    public static final String DELETE = "Ingredient.delete";
    public static final String GET_ALL = "Ingredient.all";

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
