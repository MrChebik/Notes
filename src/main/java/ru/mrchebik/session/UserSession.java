package ru.mrchebik.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by mrchebik on 08.08.16.
 */
@Component
@Scope("session")
public class UserSession {
    private static long id;

    public static void setId(final long currentId) {
        id = currentId;
    }

    public static long getId() {
        return id;
    }
}
