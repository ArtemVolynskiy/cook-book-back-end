package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.PROPERTY)
public class NamedEntity extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    public NamedEntity(){}

    NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String toString() {
        return name;
    }
}
