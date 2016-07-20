package ru.mrchebik.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.mrchebik.store.Notes_CACHE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mrchebik on 20.07.16.
 */
public class AddNoteServletTest extends Mockito {

    @Test
    public void doPost() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("title")).thenReturn("test");
        when(request.getParameter("text")).thenReturn("test");

        assertTrue(Notes_CACHE.getNotes().isEmpty());

        new AddNoteServlet().doPost(request, response);

        assertFalse(Notes_CACHE.getNotes().isEmpty());

        verify(request, atLeast(1)).getParameter("title");
        verify(request, atLeast(1)).getParameter("text");

        Notes_CACHE.clear();
    }

}