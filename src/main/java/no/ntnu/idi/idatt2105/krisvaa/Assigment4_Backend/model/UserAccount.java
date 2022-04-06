package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERACCOUNT")
public class UserAccount {

    @Id
    private Long user_id;
    private String email;
    private String password;

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public UserAccount(Long user_id, String email, String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    public UserAccount() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
