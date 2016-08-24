package ru.mrchebik.model;

/**
 * Created by mrchebik on 23.07.16.
 */
public class Note {
    private long id;
    private User user;
    private String title;
    private String text;

    public Note() {

    }

    public Note(final long id, final Object object, final String title, final String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note(final User user, final String title, final String text) {
        this.user = user;
        this.title = title;
        this.text = text;
    }

    public Note(final String title, final String text) {
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
