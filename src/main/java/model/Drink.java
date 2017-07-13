package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "drinks")
public class Drink extends BasicMealEntity {

    public Drink(){}

    public Drink (int id, String name, int calories) {
        super(id, name, calories);
    }
}
