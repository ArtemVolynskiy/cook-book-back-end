package model;



import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT DISTINCT u from User u LEFT JOIN FETCH u.userRecipes WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u from User u ORDER BY u.id, u.email"),
        @NamedQuery(name = User.FIND_BY_NAME, query = "SELECT DISTINCT u FROM  User u LEFT JOIN FETCH u.userRecipes WHERE u.name=:name"),
        @NamedQuery(name = User.FIND_BY_ID, query = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.userRecipes WHERE u.id=:id")
})

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends NamedEntity {

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_EMAIL = "User.getByEmail";
    public static final String FIND_BY_NAME = "User.findName";
    public static final String FIND_BY_ID = "User.findId";


    @Column (name = "email", nullable = false)
    @Email
    @NotEmpty
    private String email;

    @Column (name = "secondname")
    private String secondName;

    @Column (name = "nickname")
    @NotEmpty
    private String nickname;

    @Column (name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6)
    private String password;

    @Column (name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @CollectionTable (name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")})
    @Column (name = "user_role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column (name = "registered", columnDefinition = "timestamp default now()")
    @Temporal(TemporalType.DATE)
    private Date registered = new Date();

    @Column (name = "calories", nullable = false)
    @Range (min = 500, max = 6000)
    private Integer calories;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_recipe",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe>userRecipes;


    public User (){}

    public User(User user) {
        this(user.getId(), user.getName(),user.secondName, user.nickname, user.getEmail(), user.getPassword(),user.getCalories(), user.isEnabled(), user.roles);
    }

    public User(int id, String name, String secondName, String nickname, String email, String password, int calories, boolean enabled, Set<Role> roles ){
        super(id, name);
        this.email = email;
        this.secondName = secondName;
        this.nickname = nickname;
        this.password = password;
        this.calories = calories;
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

    public String getEmail() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setCalories(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Recipe> getUserRecipes() {
        return userRecipes;
    }

    public void setUserRecipes(Set<Recipe> userRecipes) {
        this.userRecipes = userRecipes;
    }

    public void addRecipe (Recipe recipe) {
        this.userRecipes.add(recipe);
    }

    public String toString() {
        return "Name: " + super.getName() +
                ", age: " + getEmail() +
                ", registration Date: " + getRegistered() +
                ", daily Calories: " + getCalories();
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
