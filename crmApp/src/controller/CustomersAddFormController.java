package controller;

import dto.CustomerDto;
import mapper.CustomerMapper;
import mapper.CustomerMapperImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CustomerAddFormController", value = "/customers/addCustomer")
public class CustomersAddFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customers/addCustomerForm.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameterMap().size()>0) {
            Map<String, String[]> paramsMap = req.getParameterMap();
            for (Map.Entry<String,String[]> mapEntry : paramsMap.entrySet()) {
                //todo jak wrócić na stronę dodawania pracownika z informacją, których pól nadal brakuje i trzeba je wypełnić
            }

        } else {
            req.setAttribute("message", "Wypełnij formularz");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/messages/userNotification.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
