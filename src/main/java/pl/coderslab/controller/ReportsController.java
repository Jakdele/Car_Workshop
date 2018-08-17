package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Order;
import pl.coderslab.service.CalculateProfitsService;
import pl.coderslab.service.DateParseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ReportsController", urlPatterns = {"/reports"})
public class ReportsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer reportType = Integer.parseInt(request.getParameter("report"));
        Date start = DateParseService.stringToDate(request.getParameter("start"));
        Date stop = DateParseService.stringToDate(request.getParameter("stop"));
        try {
            if (reportType == 1) {
                Map<Employee, Double> manhours = OrderDAO.showManhours2(start, stop);
                request.setAttribute("manhours", manhours);
                getServletContext().getRequestDispatcher("/META-INF/views/reports.jsp").forward(request, response);
            } else if (reportType == 2) {
                List<Order> profits = OrderDAO.showProfits(start, stop);
                double total = CalculateProfitsService.calculateProfits(profits);
                request.setAttribute("total", total);
                getServletContext().getRequestDispatcher("/META-INF/views/reports.jsp").forward(request, response);
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/reports.jsp").forward(request, response);

    }
}
