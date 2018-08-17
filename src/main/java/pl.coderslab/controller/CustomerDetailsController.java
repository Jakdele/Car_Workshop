package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerDetailsController", urlPatterns = {"/customerDetails"})
public class CustomerDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = new ArrayList<>();
        int customerId = Integer.parseInt(request.getParameter("customer.id"));
        try {
            vehicles = VehicleDAO.loadAllByCustomerId(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("vehicles", vehicles);
        try {
            Customer customer = CustomerDAO.loadCustomerById(customerId);
            request.setAttribute("customer", customer);
            getServletContext().getRequestDispatcher("/META-INF/views/customer_details.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
