package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeDetailsController", urlPatterns = {"/employeeDetails"})
public class EmployeeDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = new ArrayList<>();
        int employeeId = Integer.parseInt(request.getParameter("employee.id"));
        try {
            orders = OrderDAO.loadCurrentRepairsByEmployee(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("assigned", orders);
        try {
            Employee employee = EmployeeDAO.loadEmployeeById(employeeId);
            request.setAttribute("employee", employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/employee_details.jsp").forward(request, response);
    }

}
