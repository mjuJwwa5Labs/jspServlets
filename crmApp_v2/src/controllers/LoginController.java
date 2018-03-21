package controllers;

import dto.UserDto;
import service.LoginService;
import service.LoginServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import validators.Errors;
import validators.Validator;
import validators.loginForm.LoginFormPassword;
import validators.loginForm.LoginFromLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet(name="LoginController", value = {"/login", "/logged/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/loginPage.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo dodać wyświetlanie nazwy zalogowane użytkownika

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Errors errors = new Errors();
        Validator passwordValidator = new LoginFormPassword();
        passwordValidator.validate(password,errors);
        Validator loginValidator = new LoginFromLogin();
        loginValidator.validate(login,errors);

        if (errors.hasErrors()) {
            req.setAttribute("errors", errors);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/loginPage.jsp");
            dispatcher.forward(req,resp);
        } else {

            LoginService loginService = new LoginServiceImpl();
            Boolean logged = loginService.login(login,password);

            if (logged) {
                String backUrl = req.getParameter("backUrl");
                HttpSession session = req.getSession();
                UserService userService = new UserServiceImpl();
                Optional<UserDto> userDtoOptional = userService.getByLogin(login);
                UserDto userDto = null;
                if (userDtoOptional.isPresent()) {
                    userDto = userDtoOptional.get();
                }
                session.setAttribute("username",userDto.getUsername());
                session.setAttribute("login",userDto.getLogin());
                if (backUrl!=null && !backUrl.equals("")) {
                    resp.sendRedirect(backUrl);
                } else {
                    resp.sendRedirect("/logged/customers/customer");
                }
            } else {
                req.setAttribute("errorMessage","Niepoprawny użytkownik lub hasło");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/crmApp/sites/loginPage.jsp");
                requestDispatcher.forward(req,resp);
            }

        }
    }
}
