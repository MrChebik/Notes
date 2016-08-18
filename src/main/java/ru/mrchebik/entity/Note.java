package ru.mrchebik.entity;

import org.hibernate.validator.NotNull;

import javax.persistence.*;

/**
 * Created by mrchebik on 23.07.16.
 */
@Entity
@Table(name = "Notes")
public class Note {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    private long idUser;

    @NotNull
    @Column(nullable = false, length = 25)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String text;

    public Note() {

    }

    public Note(final long id, final Object object, final String title, final String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note(final long idUser, final String title, final String text) {
        this.idUser = idUser;
        this.title = title;
        this.text = text;
    }

    public Note(final String title, final String text) {
        this.title = title;
        this.text = text;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(final long idUser) {
        this.idUser = idUser;
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
