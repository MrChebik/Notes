package ru.mrchebik.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrchebik on 22.07.16.
 */
public class User {
    private long USER_ID;
    private String username;
    private String password;
    private Set<Note> notes = new HashSet<Note>(0);

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

    public long getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(final long id) {
        this.USER_ID = id;
    }

    public Set<Note> getNotes() {
        return this.notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
