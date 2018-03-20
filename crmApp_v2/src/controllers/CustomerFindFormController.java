package controllers;

import dto.CustomerDto;
import service.CustomerService;
import service.CustomerServiceImpl;
import validators.Errors;
import validators.IntegerValidator;
import validators.Validator;
import validators.customerFindForm.CustomerFindFormCustomerDto;
import validators.customerFindForm.CustomerFindFormFirstname;
import validators.customerFindForm.CustomerFindFormId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CustomerFindFormController", value = "/logged/customers/customer")
public class CustomerFindFormController extends HttpServlet{

    private List<Validator> validators = Arrays.asList(new CustomerFindFormCustomerDto(),new CustomerFindFormId(), new CustomerFindFormFirstname());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/customerFindForm.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Errors errors = new Errors();
        String idString = req.getParameter("id");
        Integer id = null;
        if (!idString.equals("")) {
            IntegerValidator integerValidator = new IntegerValidator();
            integerValidator.validate(idString,errors);
            if (!errors.hasErrors()) {
                id = Integer.valueOf(idString);
            }
        }
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");

        CustomerDto customerDto = new CustomerDto(id,firstname,lastname,null,null);
        for (Validator validator : validators) {
            validator.validate(customerDto,errors);
        }

        if (errors.hasErrors()) {
            req.setAttribute("errors", errors);
            req.setAttribute("customerDto", customerDto);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/customerFindForm.jsp");
            dispatcher.forward(req,resp);

        } else {

            CustomerService customerService = new CustomerServiceImpl();
            List<CustomerDto> customerDtoList = customerService.findByCustomerDto(customerDto);
            req.setAttribute("customerDtoList", customerDtoList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/crmApp/sites/customersList.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
