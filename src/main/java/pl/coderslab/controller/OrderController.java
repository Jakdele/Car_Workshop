package pl.coderslab.controller;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderController", urlPatterns = "/orders")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList = new ArrayList<>();
        try{
            ordersList = OrderDAO.findAllSorted();
            request.setAttribute("orders", ordersList);
            getServletContext().getRequestDispatcher("/META-INF/views/order_list.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
