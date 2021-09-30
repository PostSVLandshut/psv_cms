package de.postsportvereinlandshut.PCMS.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String firstname;

    private String lastname;

    @Column(nullable = false)
    private String psswdHsh;

    private UserGroup userGroup;

    public User(String username, String firstname, String lastname, String psswdHsh, UserGroup userGroup){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.psswdHsh = psswdHsh;
        this.userGroup = userGroup;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPsswdHsh() {
        return psswdHsh;
    }

    public void setPsswdHsh(String psswdHsh) {
        this.psswdHsh = psswdHsh;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }


}
