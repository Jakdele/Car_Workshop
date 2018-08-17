package pl.coderslab.controller;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Order;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"","/home"})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Order> current = OrderDAO.loadAllCurrentRepairs();
            request.setAttribute("current", current);
            getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
