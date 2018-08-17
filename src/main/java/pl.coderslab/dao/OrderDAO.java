package pl.coderslab.dao;

import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Order;
import pl.coderslab.service.DBManager;
import pl.coderslab.service.DateParseService;
import pl.coderslab.service.StatusService;

import java.util.*;

public class OrderDAO {
    static public void saveToDb(Order order) throws Exception {
        if (order.getId() == null) {
            addOrder(order);
        } else {
            updateOrder(order);
        }
    }

    public static List<Order> findAll() throws Exception {
        String query = "Select * from orders";
        List<Map<String, String>> data = DBManager.getData(query, null);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
        }
        return result;
    }

    public static List<Order> findAllSorted() throws Exception {
        String query = "Select * from orders order by carAccepted desc";
        List<Map<String, String>> data = DBManager.getData(query, null);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
        }
        return result;
    }

    private static Order createOrder(Map<String, String> row) throws Exception {
        Order order = new Order();
        order.setId(Integer.parseInt(row.get("id")));
        order.setCarAccepted(DateParseService.stringToDate(row.get("carAccepted")));
        order.setPlannedStart(DateParseService.stringToDate(row.get("plannedStart")));
        order.setActualStart(DateParseService.stringToDate(row.get("actualStart")));
        order.setEmployee(EmployeeDAO.loadEmployeeById(Integer.parseInt(row.get("employee_id"))));
        order.setProblemDesc(row.get("problemDesc"));
        order.setRepairDesc(row.get("repairDesc"));
        order.setStatus(StatusService.statusFromString(row.get("status")));
        order.setVehicle(VehicleDAO.loadVehicleById(Integer.parseInt(row.get("vehicle_id"))));
        order.setRepairCost(Double.parseDouble(row.get("repairCost")));
        order.setPartsCost(Double.parseDouble(row.get("partsCost")));
        order.setWage(Double.parseDouble(row.get("wage")));
        order.setManhours(Double.parseDouble(row.get("manhours")));
        return order;
    }

    private static void updateOrder(Order order) throws Exception {
        String query = "UPDATE orders SET carAccepted=?, plannedStart=?, actualStart=?, problemDesc=?, repairDesc=?, " +
                "status=?, vehicle_id=?, repairCost=?, partsCost=?, wage=?, manhours=?,  employee_id=? WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(DateParseService.dateToString(order.getCarAccepted()));
        params.add(DateParseService.dateToString(order.getPlannedStart()));
        params.add(DateParseService.dateToString(order.getActualStart()));
        params.add(order.getProblemDesc());
        params.add(order.getRepairDesc());
        params.add(StatusService.stringFromStatus(order.getStatus()));
        params.add(String.valueOf(order.getVehicle().getId()));
        params.add(String.valueOf(order.getRepairCost()));
        params.add(String.valueOf(order.getPartsCost()));
        params.add(String.valueOf(order.getWage()));
        params.add(String.valueOf(order.getManhours()));
        params.add(String.valueOf(order.getEmployee().getId()));
        params.add(String.valueOf(order.getId()));
        DBManager.executeQuery(query, params);
    }

    private static void addOrder(Order order) throws Exception {
        String query = "INSERT INTO orders VALUES(null,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<String> params = new ArrayList<>();
        params.add(DateParseService.dateToString(order.getCarAccepted()));
        params.add(DateParseService.dateToString(order.getPlannedStart()));
        params.add(DateParseService.dateToString(order.getActualStart()));
        params.add(order.getProblemDesc());
        params.add(order.getRepairDesc());
        params.add(StatusService.stringFromStatus(order.getStatus()));
        params.add(String.valueOf(order.getVehicle().getId()));
        params.add(String.valueOf(order.getRepairCost()));
        params.add(String.valueOf(order.getPartsCost()));
        params.add(String.valueOf(order.getWage()));
        params.add(String.valueOf(order.getManhours()));
        params.add(String.valueOf(order.getEmployee().getId()));
        Integer id = DBManager.insertIntoDatabase(query, params);
        order.setId(id);
    }

    public static void delete(Integer id) {
        String query = "DELETE FROM orders WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            DBManager.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Order loadOrderById(int id) throws Exception {
        String query = "SELECT * FROM orders where id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result.get(0);
        }
        return null;
    }

    public static List<Order> loadAllOrdersByVehicleId(int employeeId) throws Exception {
        String query = "SELECT * FROM orders JOIN vehicles ON orders.vehicle_id=vehicles.id WHERE vehicles.id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employeeId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result;
        }
        return null;
    }

    public static List<Order> loadAllOrdersByCustomerId(int customerId) throws Exception {
        String query = "SELECT * FROM orders JOIN customers ON orders.customer_id=customers.id WHERE customers.id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(customerId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result;
        }
        return null;
    }

    public static List<Order> loadAllCurrentRepairs() throws Exception {
        String query = "SELECT * FROM orders WHERE status='in_repair'";
        List<String> params = new ArrayList<>();
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result;
        }
        return null;
    }

    public static List<Order> loadCurrentRepairsByEmployee(int employeeId) throws Exception {
        String query = "SELECT * FROM orders WHERE status='in_repair' AND employee_id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employeeId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result;
        }
        return null;
    }


    public static List<Order> showManhours(Date start, Date stop) throws Exception {
        String query = "SELECT * FROM orders Join employees On orders.employee_id=employees.id WHERE actualStart>? AND actualStart<? GROUP BY employee_id";

        List<String> params = new ArrayList<>();
        params.add(DateParseService.dateToString(start));
        params.add(DateParseService.dateToString(stop));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result;
        }
        return null;
    }

    public static Map<Employee, Double> showManhours2(Date start, Date stop) throws Exception {
        String query = "SELECT employee_id, SUM(manhours) FROM orders Join employees On orders.employee_id=employees.id WHERE actualStart>? AND actualStart<? GROUP BY employee_id";

        List<String> params = new ArrayList<>();
        params.add(DateParseService.dateToString(start));
        params.add(DateParseService.dateToString(stop));
        List<Map<String, String>> data = DBManager.getData(query, params);

        Map<Employee, Double> manhours = new HashMap<>();
        Double totalHours = 0d;
        for (Map<String, String> row : data) {
                Employee newEmployee = EmployeeDAO.loadEmployeeById(Integer.parseInt(row.get("employee_id")));
                totalHours = Double.parseDouble(row.get("SUM(manhours)"));
                manhours.put(newEmployee, totalHours);
            return manhours;
            }

        return null;

    }



    public static List<Order> showProfits(Date start, Date stop) throws Exception {
//        String query = "SELECT repairCost, partsCost, manhours, wage FROM orders WHERE status='ready' AND actualStart>? AND actualStart<?";
        String query = "SELECT * FROM orders WHERE status='READY' AND actualStart>? AND actualStart<?";
        List<String> params = new ArrayList<>();
        params.add(DateParseService.dateToString(start));
        params.add(DateParseService.dateToString(stop));
        List<Map<String, String>> data = DBManager.getData(query, params);
        List<Order> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createOrder(row));
            return result;
        }
        return null;
    }

}
