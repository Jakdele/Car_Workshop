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
import java.util.Map;

@WebServlet(name = "OrderEditController", urlPatterns = {"/editOrder"})
public class OrderEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {
                int orderId = Integer.parseInt(request.getParameter("order-id"));
                Order orderToEdit = OrderDAO.loadOrderById(orderId);
                Date carAccepted = DateParseService.stringToDate(request.getParameter("carAccepted"));
                Date plannedStart = DateParseService.stringToDate(request.getParameter("plannedStart"));
                Date actualStart = DateParseService.stringToDate(request.getParameter("actualStart"));
                Employee employee = EmployeeDAO.loadEmployeeById(Integer.parseInt(request.getParameter("employee-id")));
                String problemDesc = request.getParameter("problemDesc");
                String repairDesc = request.getParameter("repairDesc");
                Status status = StatusService.statusFromString(request.getParameter("status"));
                Vehicle vehicle = VehicleDAO.loadVehicleById(Integer.parseInt(request.getParameter("vehicle-id")));
                if ((request.getParameter("repairCost") != "") && (request.getParameter("repairCost") != null)) {
                    Double repairCost = Double.parseDouble(request.getParameter("repairCost"));
                    orderToEdit.setManhours(repairCost);
                }
                if ((request.getParameter("partsCost") != "") && (request.getParameter("partsCost") != null)) {
                    Double partsCost = Double.parseDouble(request.getParameter("partsCost"));
                    orderToEdit.setManhours(partsCost);
                }
                if ((request.getParameter("manhours") != "") && (request.getParameter("manhours") != null)) {
                    Double manhours = Double.parseDouble(request.getParameter("manhours"));
                    orderToEdit.setManhours(manhours);
                }


                if (carAccepted != null) orderToEdit.setCarAccepted(carAccepted);
                if (plannedStart != null) orderToEdit.setPlannedStart(plannedStart);
                if (actualStart != null) orderToEdit.setActualStart(actualStart);
                if (employee != null) {
                    orderToEdit.setEmployee(employee);
                    orderToEdit.setWage();
                }
                if (problemDesc != null && problemDesc != "") orderToEdit.setProblemDesc(problemDesc);
                if (repairDesc != null && repairDesc != "") orderToEdit.setRepairDesc(repairDesc);
                if (status != null) orderToEdit.setStatus(status);
                if (vehicle != null) orderToEdit.setVehicle(vehicle);

                OrderDAO.saveToDb(orderToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/orders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idToEdit = Integer.parseInt(request.getParameter("order.id"));
        request.setAttribute("id", idToEdit);
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
        getServletContext().getRequestDispatcher("/META-INF/views/order_edit.jsp").forward(request, response);
    }
}
