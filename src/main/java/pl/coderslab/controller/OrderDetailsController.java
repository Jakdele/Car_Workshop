package pl.coderslab.controller;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Order;
import pl.coderslab.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderDetailsController", urlPatterns = {"/orderDetails"})
public class OrderDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order.id"));
        try {
            Order order = OrderDAO.loadOrderById(orderId);
            request.setAttribute("order", order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/order_details.jsp").forward(request, response);
    }

}
