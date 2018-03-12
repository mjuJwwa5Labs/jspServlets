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
import java.util.Map;

@WebServlet(name = "CustomersController", value = "/customers")
public class CustomersController extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> parametersMap = req.getParameterMap();
        if (hasParameters(parametersMap)) {
            if (parametersMap.containsKey("customerId")) {
               resp.sendRedirect("/customers/customerDetails");
            }
        } else {
            doGet(req,resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerService customerService = CustomerServiceFactory.factory("csv");
        List<CustomerDto> customerDtoList = customerService.getAllCustomers();
        req.setAttribute("customerDtoList", customerDtoList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/customers/customers.jsp");
        requestDispatcher.forward(req,resp);
    }

    private boolean hasParameters(Map<String,String[]> parametersMap) {
        return parametersMap.size()>0;
    }

}
