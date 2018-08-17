package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.VehicleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VehicleDeleteController", urlPatterns = {"/deleteVehicle"})
public class VehicleDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Yes")) {
            try {
                VehicleDAO.delete(Integer.parseInt(request.getParameter("vehicle.id")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/vehicles");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTodelete = Integer.parseInt(request.getParameter("vehicle.id"));
            request.setAttribute("id", idTodelete);
            getServletContext().getRequestDispatcher("/META-INF/views/vehicle_delete.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
