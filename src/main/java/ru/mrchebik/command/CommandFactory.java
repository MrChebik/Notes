package ru.mrchebik.command;

import ru.mrchebik.interfaces.Command;

import ru.mrchebik.dao.DAO;

/**
 * Created by mrchebik on 02.08.16.
 */
public class CommandFactory extends DAO {

    public <T> T transaction(final Command<T> command) {
        begin();
        try {
            return command.process();
        } finally {
            commit();
            close();
        }
    }

}
