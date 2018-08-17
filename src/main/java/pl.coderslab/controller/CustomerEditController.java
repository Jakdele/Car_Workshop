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

@WebServlet(name = "CustomerEditController", urlPatterns = {"/editCustomer"})
public class CustomerEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {
                Integer customerId = Integer.parseInt(request.getParameter("customer-id"));
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                LocalDate birthday = DateParseService.stringToLocalDate(request.getParameter("birthday"));


                Customer customerToEdit = CustomerDAO.loadCustomerById(customerId);
                if (name != null && name != "") customerToEdit.setName(name);
                if (surname != null && surname != "") customerToEdit.setSurname(surname);
                if (phone != null && phone != "") customerToEdit.setSurname(phone);
                if (address != null && address != "") customerToEdit.setAddress(address);
                if (birthday != null) customerToEdit.setBirthday(birthday);

                CustomerDAO.saveToDb(customerToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idToEdit = Integer.parseInt(request.getParameter("customer.id"));
        request.setAttribute("id", idToEdit);
        getServletContext().getRequestDispatcher("/META-INF/views/customer_edit.jsp").forward(request, response);
    }
}
