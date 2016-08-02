package ru.mrchebik.servlets;

import ru.mrchebik.dao.NoteDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrchebik on 19.07.16.
 */
public class ViewNotesServlet extends HttpServlet {

    private NoteDAO notesDAO = new NoteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("notes", notesDAO.get((Long) request.getSession().getAttribute("idUser")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/ViewNotes.jsp").forward(request, response);
    }

}
