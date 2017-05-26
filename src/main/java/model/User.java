package model;


import java.util.Date;

public class User extends NamedEntity {

    private String email;
    private String password;
    private boolean enabled;
    private Date registered = new Date();


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
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

    public Date getRegistered() {
        return registered;
    }
}
