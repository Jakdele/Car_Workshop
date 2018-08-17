package pl.coderslab.dao;

import pl.coderslab.entity.Customer;
import pl.coderslab.entity.Employee;
import pl.coderslab.service.DBManager;
import pl.coderslab.service.DateParseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
    static public void saveToDb(Customer customer) throws Exception {
        if (customer.getId() == null) {
            addCustomer(customer);
        } else {
            updateCustomer(customer);
        }
    }

    public static List<Customer> findAll() throws Exception {
        String query = "Select * from customers";
        List<Map<String, String>> data = DBManager.getData(query, null);

        List<Customer> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createCustomer(row));
        }
        return result;
    }

    private static Customer createCustomer(Map<String, String> row) {
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(row.get("id")));
        customer.setName(row.get("name"));
        customer.setSurname(row.get("surname"));
        customer.setPhone(row.get("phone"));
        customer.setAddress(row.get("address"));
        customer.setBirthday(DateParseService.stringToLocalDate(row.get("birthday")));
        return customer;
    }

    private static void updateCustomer(Customer customer) throws Exception {
        String query = "UPDATE customers SET name=?, surname=?, phone=?, address=?, birthday=? WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(customer.getName());
        params.add(customer.getSurname());
        params.add(customer.getPhone());
        params.add(customer.getAddress());
        params.add(DateParseService.localDateToString(customer.getBirthday()));
        params.add(String.valueOf(customer.getId()));
        DBManager.executeQuery(query, params);
    }

    private static void addCustomer(Customer customer) throws Exception {
        String query = "INSERT INTO customers VALUES(null,?, ?, ?, ?, ?)";
        List<String> params = new ArrayList<>();
        params.add(customer.getName());
        params.add(customer.getSurname());
        params.add(customer.getPhone());
        params.add(customer.getAddress());
        params.add(DateParseService.localDateToString(customer.getBirthday()));
        Integer id = DBManager.insertIntoDatabase(query, params);
        customer.setId(id);
    }

    public static void delete(Integer id) {
        String query = "DELETE FROM customers WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            DBManager.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Customer loadCustomerById(int id) throws Exception {
        String query = "SELECT * FROM customers where id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Customer> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createCustomer(row));
            return result.get(0);
        }
        return null;
    }

    public static List<Customer> searchForName(String name) throws Exception {
        String query = "SELECT * FROM customers WHERE INSTR(surname, ?)";
        List<String> params = new ArrayList<>();
        params.add(name);
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Customer> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createCustomer(row));
        }
        return result;
    }

    public static List<Customer> loadAllVehiclesByCustomerId(int customerId) throws Exception {
        String query = "SELECT * FROM vehicles JOIN customers ON vehicles.customer_id=customers.id WHERE customers.id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(customerId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Customer> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createCustomer(row));

        }
        return result;
    }

    public static List<Customer> loadAllOrdersByCustomerId(int customerId) throws Exception {
        String query = "SELECT * FROM customers JOIN orders ON orders.customer_id=customers.id WHERE customers.id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(customerId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Customer> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createCustomer(row));

        }
        return result;
    }
}
