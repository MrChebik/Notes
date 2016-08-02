package ru.mrchebik.servlets;

import ru.mrchebik.dao.NoteDAO;
import ru.mrchebik.entity.Note;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mrchebik on 19.07.16.
 */
public class AddNoteServlet extends HttpServlet {

    private final NoteDAO noteDAO = new NoteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/AddNote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            noteDAO.add(new Note((Long) request.getSession().getAttribute("idUser"), request.getParameter("title"), request.getParameter("text")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/AddNote.jsp").forward(request, response);
    }

}
