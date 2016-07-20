package ru.mrchebik.servlets;

import ru.mrchebik.store.Notes_CACHE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrchebik on 19.07.16.
 */
public class ViewNotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("notes", Notes_CACHE.getNotes());
        request.getRequestDispatcher("/views/ViewNotes.jsp").forward(request, response);
    }

}
