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

@WebServlet(name = "EmployeeEditController", urlPatterns = {"/editEmployee"})
public class EmployeeEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {
                int employeeId = Integer.parseInt(request.getParameter("employee-id"));
                Employee employeeToEdit = EmployeeDAO.loadEmployeeById(employeeId);
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String note = request.getParameter("note");
                if((request.getParameter("wage")!="") && (request.getParameter("wage")!=null)) {
                    Double wage = Double.parseDouble(request.getParameter("wage"));
                    employeeToEdit.setWage(wage);
                }


                if (name != null && name != "") employeeToEdit.setName(name);
                if (surname != null && surname != "") employeeToEdit.setSurname(surname);
                if (phone != null && phone != "") employeeToEdit.setSurname(phone);
                if (address != null && address != "") employeeToEdit.setAddress(address);
                if (note != null && note != "") employeeToEdit.setNote(note);

                EmployeeDAO.saveToDb(employeeToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idToEdit = Integer.parseInt(request.getParameter("employee.id"));
        request.setAttribute("id", idToEdit);
        getServletContext().getRequestDispatcher("/META-INF/views/employee_edit.jsp").forward(request, response);
    }
}
