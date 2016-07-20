package ru.mrchebik.servlets;

import ru.mrchebik.models.Note;
import ru.mrchebik.store.Notes_CACHE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrchebik on 19.07.16.
 */
public class AddNoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/AddNote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Notes_CACHE.addNote(new Note(request.getParameter("title"), request.getParameter("text")));
    }

}
