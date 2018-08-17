package pl.coderslab.controller;

import pl.coderslab.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDeleteController", urlPatterns = {"/deleteOrder"})
public class OrderDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Yes")) {
            try {
                OrderDAO.delete(Integer.parseInt(request.getParameter("order.id")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/orders");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTodelete = Integer.parseInt(request.getParameter("order.id"));
            request.setAttribute("id", idTodelete);
            getServletContext().getRequestDispatcher("/META-INF/views/order_delete.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
