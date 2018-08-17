package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VehicleController", urlPatterns = "/vehicles")
public class VehicleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehiclesList = new ArrayList<>();
        try{
            vehiclesList = VehicleDAO.findAll();
            request.setAttribute("vehicles", vehiclesList);
            getServletContext().getRequestDispatcher("/META-INF/views/vehicle_list.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
