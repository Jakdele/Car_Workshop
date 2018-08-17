package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = "/employees")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeesList = new ArrayList<>();
        try{
            employeesList = EmployeeDAO.findAll();
            request.setAttribute("employees", employeesList);
            getServletContext().getRequestDispatcher("/META-INF/views/employee_list.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
