package pl.coderslab.dao;

import pl.coderslab.entity.Employee;
import pl.coderslab.service.DBManager;
import pl.coderslab.service.DateParseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {
    static public void saveToDb(Employee employee) throws Exception {
        if (employee.getId() == null) {
            addEmployee(employee);
        } else {
            updateEmployee(employee);
        }
    }

    public static List<Employee> findAll() throws Exception {
        String query = "Select * from employees";
        List<Map<String, String>> data = DBManager.getData(query, null);

        List<Employee> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createEmployee(row));
        }
        return result;
    }

    private static Employee createEmployee(Map<String, String> row) {
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(row.get("id")));
        employee.setName(row.get("name"));
        employee.setSurname(row.get("surname"));
        employee.setPhone(row.get("phone"));
        employee.setAddress(row.get("address"));
        employee.setNote(row.get("note"));
        employee.setWage(Double.parseDouble(row.get("wage")));
        return employee;
    }

    private static void updateEmployee(Employee employee) throws Exception {
        String query = "UPDATE employees SET name=?, surname=?, phone=?, address=?, note=?, wage=? WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(employee.getName());
        params.add(employee.getSurname());
        params.add(employee.getPhone());
        params.add(employee.getAddress());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getWage()));
        params.add(String.valueOf(employee.getId()));
        DBManager.executeQuery(query, params);
    }

    private static void addEmployee(Employee employee) throws Exception {
        String query = "INSERT INTO employees VALUES(null,?, ?, ?, ?, ?, ?)";
        List<String> params = new ArrayList<>();
        params.add(employee.getName());
        params.add(employee.getSurname());
        params.add(employee.getPhone());
        params.add(employee.getAddress());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getWage()));
        Integer id = DBManager.insertIntoDatabase(query, params);
        employee.setId(id);
    }

    public static void delete(Integer id) {
        String query = "DELETE FROM employees WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            DBManager.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Employee loadEmployeeById(int id) throws Exception {
        String query = "SELECT * FROM employees where id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Employee> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createEmployee(row));
            return result.get(0);
        }
        return null;
    }

    public static List<Employee> loadAllOrdersByEmployeeId(int employeeGroupId) throws Exception {
        String query = "SELECT * FROM employees JOIN orders ON orders.employee_id=employees.id WHERE employees.id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employeeGroupId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Employee> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createEmployee(row));

        }
        return result;
    }
}