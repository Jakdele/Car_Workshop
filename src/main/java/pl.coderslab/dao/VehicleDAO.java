package pl.coderslab.dao;

import pl.coderslab.entity.Vehicle;
import pl.coderslab.service.DBManager;
import pl.coderslab.service.DateParseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDAO {


    static public void saveToDb(Vehicle vehicle) throws Exception {
        if (vehicle.getId() == null) {
            addVehicle(vehicle);
        } else {
            updateVehicle(vehicle);
        }
    }

    public static List<Vehicle> findAll() throws Exception {
        String query = "Select * from vehicles";
        List<Map<String, String>> data = DBManager.getData(query, null);

        List<Vehicle> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createVehicle(row));
        }
        return result;
    }

    private static Vehicle createVehicle(Map<String, String> row) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(Integer.parseInt(row.get("id")));
        vehicle.setMake(row.get("make"));
        vehicle.setModel(row.get("model"));
        vehicle.setManufactured(Integer.parseInt(row.get("manufactured")));
        vehicle.setRegNumber(row.get("regNumber"));
        vehicle.setNextReview(DateParseService.stringToLocalDate(row.get("nextReview")));
        vehicle.setOwner(CustomerDAO.loadCustomerById(Integer.parseInt(row.get("customer_id"))));
        return vehicle;
    }

    private static void updateVehicle(Vehicle vehicle) throws Exception {
        String query = "UPDATE vehicles SET make=?, model=?, manufactured=?, regNumber=?, nextReview=?, customer_id=? WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(vehicle.getMake());
        params.add(vehicle.getModel());
        params.add(String.valueOf(vehicle.getManufactured()));
        params.add(vehicle.getRegNumber());
        params.add(DateParseService.localDateToString(vehicle.getNextReview()));
        params.add(String.valueOf(vehicle.getOwner().getId()));
        params.add(String.valueOf(vehicle.getId()));
        DBManager.executeQuery(query, params);
    }

    private static void addVehicle(Vehicle vehicle) throws Exception {
        String query = "INSERT INTO vehicles VALUES(null,?, ?, ?, ?, ?, ?)";
        List<String> params = new ArrayList<>();
        params.add(vehicle.getMake());
        params.add(vehicle.getModel());
        params.add(String.valueOf(vehicle.getManufactured()));
        params.add(vehicle.getRegNumber());
        params.add(DateParseService.localDateToString(vehicle.getNextReview()));
        params.add(String.valueOf(vehicle.getOwner().getId()));
        Integer id = DBManager.insertIntoDatabase(query, params);
        vehicle.setId(id);
    }

    public static void delete(Integer id) {
        String query = "DELETE FROM vehicles WHERE id =?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        try {
            DBManager.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Vehicle loadVehicleById(int id) throws Exception {
        String query = "SELECT * FROM vehicles where id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Vehicle> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createVehicle(row));
            return result.get(0);
        }
        return null;
    }

    public static List<Vehicle> loadAllByCustomerId(int vehicleGroupId) throws Exception {
        String query = "SELECT * FROM vehicles JOIN customers ON vehicles.customer_id=customers.id WHERE customer_id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(vehicleGroupId));
        List<Map<String, String>> data = DBManager.getData(query, params);

        List<Vehicle> result = new ArrayList<>();
        for (Map<String, String> row : data) {
            result.add(createVehicle(row));
        }
        return result;
    }
}
