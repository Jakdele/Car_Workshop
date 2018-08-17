package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeDeleteController", urlPatterns = {"/deleteEmployee"})
public class EmployeeDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Yes")) {
            try {
                EmployeeDAO.delete(Integer.parseInt(request.getParameter("employee.id")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/employees");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTodelete = Integer.parseInt(request.getParameter("employee.id"));
            request.setAttribute("id", idTodelete);
            getServletContext().getRequestDispatcher("/META-INF/views/employee_delete.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
