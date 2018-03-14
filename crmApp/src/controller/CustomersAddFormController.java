package controller;

import service.CustomerAddFormValidatorService;
import service.FormValidatorService;
import validator.CustomerAddFormValidator;
import validator.FormValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

@WebServlet(name = "CustomerAddFormController", value = "/customers/addCustomer")
public class CustomersAddFormController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        switch(method) {
            case "GET":
                System.out.println("GET " + LocalTime.now()); //todo
                doGet(req,resp);
                break;
            case "POST":
                System.out.println("POST " + LocalTime.now()); //todo
                doPost(req,resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("formNotCorrect", false);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customers/addCustomerForm.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FormValidatorService validatorService = new CustomerAddFormValidatorService();
        Map<String,String> requestParametersAfterMapping = validatorService.requestParametersToMap(req.getParameterMap());
        FormValidator validator = new CustomerAddFormValidator();

        System.out.println("POST, ParametersMapSize = " + requestParametersAfterMapping.size() + ", " + LocalTime.now()); //todo
        Map<String,String> validationResult = validatorService.validateForm(req.getParameterMap());

        if (!validatorService.formCorrect(req.getParameterMap())) {
            req.setAttribute("formNotCorrect", true);
            req.setAttribute("parametersMap", requestParametersAfterMapping);
            req.setAttribute("validationResult",validationResult);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customers/addCustomerForm.jsp");
            System.out.println("form not correct " + LocalTime.now()); //todo
            requestDispatcher.forward(req,resp);
        } else {
            req.setAttribute("message", "Tutaj będzie obsługa dodawania użytkownika");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/messages/userNotification.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
