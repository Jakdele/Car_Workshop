package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.Vehicle;
import pl.coderslab.service.DateParseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VehicleAddController", urlPatterns = {"/addVehicle"})
public class VehicleAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {
                String make = request.getParameter("make");
                String model = request.getParameter("model");
                int manufactured = Integer.parseInt(request.getParameter("manufactured"));
                String regNum = request.getParameter("regNumber");
                LocalDate reviewDate = DateParseService.stringToLocalDate(request.getParameter("nextReview"));
                Customer owner = CustomerDAO.loadCustomerById(Integer.parseInt(request.getParameter("customer-id")));

                Vehicle newVehicle = new Vehicle(make, model, manufactured, regNum, reviewDate, owner);
                VehicleDAO.saveToDb(newVehicle);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/vehicles");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = CustomerDAO.findAll();
            request.setAttribute("customers", customers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/vehicle_add.jsp").forward(request, response);
    }
}
