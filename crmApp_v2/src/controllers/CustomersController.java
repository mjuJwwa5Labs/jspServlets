package controllers;

import dto.CustomerDto;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="CustomersController", value = "/customers")
public class CustomersController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerServiceImpl();
        List<CustomerDto> customerDtoList = customerService.getAllCustomers();
        req.setAttribute("customerDtoList", customerDtoList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/customersList.jsp");
        dispatcher.forward(req,resp);
    }
}
