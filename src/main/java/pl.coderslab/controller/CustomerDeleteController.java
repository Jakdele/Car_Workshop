package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerDeleteController", urlPatterns = {"/deleteCustomer"})
public class CustomerDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Yes")) {
            try {
                CustomerDAO.delete(Integer.parseInt(request.getParameter("customer.id")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/customers");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTodelete = Integer.parseInt(request.getParameter("customer.id"));
            request.setAttribute("id", idTodelete);
            getServletContext().getRequestDispatcher("/META-INF/views/customer_delete.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
