package pl.coderslab.service;

import pl.coderslab.entity.Order;

import java.util.List;

public class CalculateProfitsService {

    public static double calculateProfits(List<Order> orders) {
        double profit = 0d;
        if(orders!=null) {
            for (Order order : orders) {
                profit += order.getRepairCost() - order.getPartsCost() - order.getWage() * order.getManhours();
            }
            return profit;
        } else {
            return 0d;
        }
    }
}
