package ru.mrchebik.command;

/**
 * Created by mrchebik on 02.08.16.
 */
public interface Command<T> {
    T process();
}