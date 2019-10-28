package com.wdr.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="username")
    private String username;

    @Column(name="active",columnDefinition = "TINYINT(1)")
    private boolean active;

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.active = user.getActive();
        this.roles = user.getRoles();
        this.id = user.getId();
        this.password = user.getPassword();
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }
}
