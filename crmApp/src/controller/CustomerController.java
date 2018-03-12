package controller;


import dto.CustomerDto;
import service.CustomerService;
import service.CustomerServiceCsvImpl;
import service.CustomerServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerService customerService = CustomerServiceFactory.factory("csv");
        List<CustomerDto> customerDtoList = customerService.getAllCustomers();
        req.setAttribute("customerDtoList", customerDtoList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customers/customers.jsp");
        requestDispatcher.forward(req,resp);
    }
}
