package ru.mrchebik.entity;

import org.hibernate.validator.NotNull;

import javax.persistence.*;

/**
 * Created by mrchebik on 22.07.16.
 */
@Entity
@Table(name = "Users")
public class User {

    @Id @GeneratedValue
    @Column(unique = true)
    private long id;

    @NotNull
    @Column(unique = true, nullable = false, length = 12)
    private String username;

    @NotNull
    @Column(nullable = false, length = 16)
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    protected void setId(final long id) {
        this.id = id;
    }

}
