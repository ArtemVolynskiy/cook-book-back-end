package model;



import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

@NamedQueries({
            @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
            @NamedQuery(name = User.BY_EMAIL, query = "SELECT u from User u WHERE u.email=?1"),
            @NamedQuery(name = User.ALL_SORTED, query = "SELECT u from User u ORDER BY u.id, u.email")
    })

    @Entity
    @Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends NamedEntity {

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_EMAIL = "User.getByEmail";


    @Column (name = "email", nullable = false)
    @Email
    @NotEmpty
    private String email;

    @Column (name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6, max = 50)
    private String password;

    @Column (name = "enabled", nullable = false)
    private boolean enabled;

    @Column (name = "isadmin", nullable = false)
    private boolean isAdmin;

    @Column (name = "registered", columnDefinition = "timestamp default now")
    private Date registered = new Date();

    @Column (name = "calories", nullable = false)
    private Integer calories;


    public User (){}

    public User(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(),user.getCalories(), user.isEnabled(), user.isAdmin);
    }

    public User(int id, String name, String email, String password, int calories, boolean enabled, boolean isAdmin ){
        super(id, name);
        this.email = email;
        this.password = password;
        this.calories = calories;
        this.enabled = enabled;
        this.isAdmin = isAdmin;

    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    private String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isEnabled(){
        return this.enabled;
    }

    private Date getRegistered() {
        return registered;
    }

    private Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    public String toString() {
        return "Name: " + super.getName() +
                ", age: " + getEmail() +
                ", registration Date: " + getRegistered() +
                ", daily Calories: " + getCalories();
    }


}
