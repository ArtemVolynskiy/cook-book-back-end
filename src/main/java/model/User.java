package model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @Column (name = "registered", columnDefinition = "timestamp default now")
    private Date registered = new Date();

    @Column (name = "calories", nullable = false)
    private Integer calories;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_role")
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User (){}

    public User(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(), user.roles);
    }

    public User(int id, String name, String email, String password, boolean enabled, Set<Role> roles ){
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;

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

    public String toString() {
        return "Name: " + super.getName() +
                "Age: " + getEmail() +
                "Registration Date: " + getRegistered() +
                "Daily Calories: " + getCalories();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
