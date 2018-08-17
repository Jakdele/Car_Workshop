package pl.coderslab.controller;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Order;
import pl.coderslab.entity.Vehicle;
import pl.coderslab.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VehicleDetailsController", urlPatterns = {"/vehicleDetails"})
public class VehicleDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int vehicleId = Integer.parseInt(request.getParameter("vehicle.id"));
        List<Order> vehicleRepairs = new ArrayList<>();
        try{
            vehicleRepairs = OrderDAO.loadAllOrdersByVehicleId(vehicleId);
            request.setAttribute("orders", vehicleRepairs);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Vehicle vehicle = VehicleDAO.loadVehicleById(vehicleId);
            request.setAttribute("vehicle", vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/vehicle_details.jsp").forward(request, response);
    }

}
