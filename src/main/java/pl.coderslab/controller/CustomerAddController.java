package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.entity.Customer;
import pl.coderslab.service.DateParseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CustomerAddController", urlPatterns = {"/addCustomer"})
public class CustomerAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                LocalDate birthday = DateParseService.stringToLocalDate(request.getParameter("birthday"));


                Customer newCustomer = new Customer(name, surname, phone, address,birthday);

                CustomerDAO.saveToDb(newCustomer);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/customer_add.jsp").forward(request, response);
    }
}
