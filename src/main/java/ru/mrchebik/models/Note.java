package ru.mrchebik.models;

/**
 * Created by mrchebik on 19.07.16.
 */
public class Note implements ru.mrchebik.interfaces.Note {

    private String title;
    private String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

}
