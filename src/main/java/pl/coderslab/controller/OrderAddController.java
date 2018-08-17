package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.OrderDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Order;
import pl.coderslab.entity.Status;
import pl.coderslab.entity.Vehicle;
import pl.coderslab.service.DateParseService;
import pl.coderslab.service.StatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderAddController", urlPatterns = {"/addOrder"})
public class OrderAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {

                Double repairCost = 0d;
                Double partsCost = 0d;
                Double manhours = 0d;
                Date carAccepted = DateParseService.stringToDate(request.getParameter("carAccepted"));
                Date plannedStart = DateParseService.stringToDate(request.getParameter("plannedStart"));
                Date actualStart = DateParseService.stringToDate(request.getParameter("actualStart"));
                Employee employee = EmployeeDAO.loadEmployeeById(Integer.parseInt(request.getParameter("employee-id")));
                String problemDesc = request.getParameter("problemDesc");
                String repairDesc = request.getParameter("repairDesc");
                Status status = StatusService.statusFromString(request.getParameter("status"));
                Vehicle vehicle = VehicleDAO.loadVehicleById(Integer.parseInt(request.getParameter("vehicle-id")));
                if ((request.getParameter("repairCost") != "") && (request.getParameter("repairCost") != null)) {
                    repairCost = Double.parseDouble(request.getParameter("repairCost"));
                }
                if ((request.getParameter("partsCost") != "") && (request.getParameter("partsCost") != null)) {
                    partsCost = Double.parseDouble(request.getParameter("partsCost"));
                }
                if ((request.getParameter("manhours") != "") && (request.getParameter("manhours") != null)) {
                    manhours = Double.parseDouble(request.getParameter("manhours"));
                }

                Order newOrder = new Order(carAccepted, plannedStart, actualStart, employee, problemDesc, repairDesc, status, vehicle, repairCost, partsCost, manhours);


                OrderDAO.saveToDb(newOrder);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/orders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        try {
            vehicles = VehicleDAO.findAll();
            request.setAttribute("vehicles", vehicles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            employees = EmployeeDAO.findAll();
            request.setAttribute("employees", employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/order_add.jsp").forward(request, response);
    }
}
