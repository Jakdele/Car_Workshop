package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.entity.Customer;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customersList = new ArrayList<>();
        try{
            customersList = CustomerDAO.findAll();
            request.setAttribute("customers", customersList);
            getServletContext().getRequestDispatcher("/META-INF/views/customer_list.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
