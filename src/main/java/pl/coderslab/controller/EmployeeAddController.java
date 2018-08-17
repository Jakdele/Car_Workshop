package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.entity.Employee;
import pl.coderslab.service.DateParseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "EmployeeAddController", urlPatterns = {"/addEmployee"})
public class EmployeeAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String note = request.getParameter("note");
                Double wage = Double.parseDouble(request.getParameter("wage"));


                Employee newEmployee = new Employee(name, surname, phone, address,note, wage);
                EmployeeDAO.saveToDb(newEmployee);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/employee_add.jsp").forward(request, response);
    }
}
