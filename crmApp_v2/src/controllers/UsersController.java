package controllers;

import entity.UserGroups;
import validators.Errors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UsersController", value = "/logged/users")
public class UsersController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserGroups userGroup = (UserGroups) session.getAttribute("userGroup");

        if (userGroup.equals(UserGroups.ADMIN)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/userManagement.jsp");
            dispatcher.forward(req,resp);
        } else {
            Errors errors = new Errors();
            errors.addError("errorMessage","Nie masz uprawnień do tej części aplikacji");
            req.setAttribute("errors", errors);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/userManagement.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
