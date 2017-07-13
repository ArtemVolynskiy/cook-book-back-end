package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "snacks")
@NamedQuery(name = Snack.GET_ALL, query = "SELECT s FROM Snack s")
public class Snack extends BasicMealEntity {
    public static final String GET_ALL = "getAllSnacks";

    public Snack(){}

    public Snack (int id, String name, int calories) {
        super(id, name, calories);
    }
}
