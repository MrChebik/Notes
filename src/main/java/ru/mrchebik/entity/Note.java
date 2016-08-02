package ru.mrchebik.entity;

import javax.persistence.*;

/**
 * Created by mrchebik on 23.07.16.
 */
@Entity
@Table(name = "Notes")
public class Note {

    @Id
    @JoinColumn(name = "id")
    private long id;
    private String title;
    private String text;

    public Note() {

    }

    public Note(long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
