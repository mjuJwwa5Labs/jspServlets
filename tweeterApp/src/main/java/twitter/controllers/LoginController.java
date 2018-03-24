package twitter.controllers;

import twitter.service.LoginService;
import twitter.service.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet{

    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tweets_jstl/login/loginPage.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean logged = loginService.login(username,password);

        if (logged) {
            String backUrl = req.getParameter("backUrl");
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            if (backUrl!=null && !backUrl.equals("")) {
                resp.sendRedirect(backUrl);
            } else {
                resp.sendRedirect("/myTweets");
            }
        } else {
            req.setAttribute("errorMessage","Niepoprawny użytkownik lub hasło");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tweets_jstl/login/loginPage.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
