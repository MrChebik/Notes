package ru.mrchebik.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.mrchebik.store.Notes_CACHE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by mrchebik on 20.07.16.
 */
public class ViewNotesServletTest extends Mockito {

    @Test
    public void doGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);

        doNothing().when(request).setAttribute("notes", Notes_CACHE.getNotes());

        assertEquals(request.getAttribute("notes"), Notes_CACHE.getNotes());

        verify(request, atLeast(1)).setAttribute("notes", Notes_CACHE.getNotes());
    }

}