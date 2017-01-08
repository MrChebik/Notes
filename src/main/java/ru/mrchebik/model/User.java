package ru.mrchebik.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrchebik on 22.07.16.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long userId;

    @Column(unique = true, nullable = false, length = 60)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    private String passwordConfirm;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Note> notes = new HashSet<Note>(0);

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;

    public User() {}

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long id) {
        this.userId = id;
    }

    public Set<Note> getNotes() {
        return this.notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
