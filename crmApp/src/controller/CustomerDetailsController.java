package controller;

import dto.CustomerDto;
import service.CustomerService;
import service.CustomerServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerDetailsController", value = "/customers/customerDetails")
public class CustomerDetailsController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerService customerService = CustomerServiceFactory.factory("csv");
        try {

            Integer id = Integer.valueOf(req.getParameter("customerId"));
            CustomerDto customerDto = customerService.getById(id);
            List<CustomerDto> customerDtoList = new ArrayList<>();
            customerDtoList.add(customerDto);
            req.setAttribute("customerDtoList", customerDtoList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customers/customers.jsp");
            requestDispatcher.forward(req,resp);

        } catch (NumberFormatException e) {
            req.setAttribute("message", "To nie jest poprawny numer klienta");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/messages/userNotification.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

}
