package ru.mrchebik.model;

import javax.persistence.*;

/**
 * Created by mrchebik on 23.07.16.
 */
@Entity
@Table(name = "Notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false, length = 25)
    private String title;

    @Column(nullable = false)
    private String text;

    public Note() {

    }

    public Note(final long id, final String title, final String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note(final User user, final String title, final String text) {
        this.user = user;
        this.title = title;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

}
