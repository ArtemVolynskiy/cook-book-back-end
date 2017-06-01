package model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Access(AccessType.FIELD)
public class NamedEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    public NamedEntity(){}

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
