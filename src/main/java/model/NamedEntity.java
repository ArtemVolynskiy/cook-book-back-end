package model;


public class NamedEntity extends BaseEntity {
    private String name;

    public NamedEntity(){}

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
