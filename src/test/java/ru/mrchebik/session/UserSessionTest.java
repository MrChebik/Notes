package ru.mrchebik.session;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mrchebik on 09.08.16.
 */
public class UserSessionTest {
    @Test
    public void setGetId() throws Exception {
        UserSession.setId(20);
        assertEquals(UserSession.getId(), 20);
    }
}