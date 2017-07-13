package model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BasicMealEntity extends NamedEntity {
    private int calories;
    public BasicMealEntity() {}

    BasicMealEntity(int id, String name, int calories) {
        super(id, name);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
