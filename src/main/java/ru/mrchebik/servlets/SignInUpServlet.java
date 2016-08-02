package ru.mrchebik.servlets;

import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import ru.mrchebik.dao.UserDAO;
import ru.mrchebik.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by mrchebik on 21.07.16.
 */
public class SignInUpServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/sign/SignInUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("hide").equals("up")) {
            try {
                userDAO.add(new User(request.getParameter("login"), request.getParameter("password")));
            } catch (TransactionException e) {
                request.getRequestDispatcher("/views/sign/Dublicate.jsp").forward(request, response);
            }
        }

        User user = null;
        try {
            user = userDAO.get(request.getParameter("login"));
        } catch (NoSuchElementException e) {
            request.getRequestDispatcher("/views/sign/NotRegister.jsp").forward(request, response);
        }
        request.getSession().setAttribute("idUser", user.getId());
        request.getRequestDispatcher("/views/Notes.jsp").forward(request, response);
    }
}