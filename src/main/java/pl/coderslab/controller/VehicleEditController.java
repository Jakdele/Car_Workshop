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

@WebServlet(name = "VehicleEditController", urlPatterns = {"/editVehicle"})
public class VehicleEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {
                int vehicleId = Integer.parseInt(request.getParameter("vehicle-id"));
                String make = request.getParameter("make");
                String model = request.getParameter("model");
                Integer manufactured = Integer.parseInt(request.getParameter("manufactured"));
                String regNum = request.getParameter("regNumber");
                LocalDate reviewDate = DateParseService.stringToLocalDate(request.getParameter("nextReview"));
                Customer owner = CustomerDAO.loadCustomerById(Integer.parseInt(request.getParameter("customer-id")));



                Vehicle vehicleToEdit = VehicleDAO.loadVehicleById(vehicleId);
                if (make != null && make != "") vehicleToEdit.setMake(make);
                if (model != null && model != "") vehicleToEdit.setModel(model);
                if (manufactured != null) vehicleToEdit.setManufactured(manufactured);
                if (regNum != null && regNum != "") vehicleToEdit.setRegNumber(regNum);
                if (reviewDate != null) vehicleToEdit.setNextReview(reviewDate);
                if (owner != null) vehicleToEdit.setOwner(owner);

                VehicleDAO.saveToDb(vehicleToEdit);

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
        Integer idToEdit = Integer.parseInt(request.getParameter("vehicle.id"));
        request.setAttribute("id", idToEdit);
        getServletContext().getRequestDispatcher("/META-INF/views/vehicle_edit.jsp").forward(request, response);
    }
}
