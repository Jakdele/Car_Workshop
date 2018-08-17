package pl.coderslab.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private Date carAccepted;
    private Date plannedStart;
    private Date actualStart;
    private Employee employee;
    private String problemDesc;
    private String repairDesc;
    private Status status;
    private Vehicle vehicle;
    private double repairCost;
    private double partsCost;
    private double wage;
    private double manhours;

    public Order() {
    }

    public Order(Date carAccepted, Date plannedStart, Date actualStart, Employee employee, String problemDesc, String repairDesc, Status status, Vehicle vehicle, double repairCost, double partsCost, double manhours) {
        this.carAccepted = carAccepted;
        this.plannedStart = plannedStart;
        this.actualStart = actualStart;
        this.employee = employee;
        this.problemDesc = problemDesc;
        this.repairDesc = repairDesc;
        this.status = status;
        this.vehicle = vehicle;
        this.repairCost = repairCost;
        this.partsCost = partsCost;
        this.manhours = manhours;
    }

    public Order(Integer id, Date carAccepted, Date plannedStart, Date actualStart, Employee employee, String problemDesc, String repairDesc, Status status, Vehicle vehicle, double repairCost, double partsCost, double manhours) {
        this.id = id;
        this.carAccepted = carAccepted;
        this.plannedStart = plannedStart;
        this.actualStart = actualStart;
        this.employee = employee;
        this.problemDesc = problemDesc;
        this.repairDesc = repairDesc;
        this.status = status;
        this.vehicle = vehicle;
        this.repairCost = repairCost;
        this.partsCost = partsCost;
        this.wage = this.employee.getWage();
        this.manhours = manhours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCarAccepted() {
        return carAccepted;
    }

    public void setCarAccepted(Date carAccepted) {
        this.carAccepted = carAccepted;
    }

    public Date getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(Date plannedStart) {
        this.plannedStart = plannedStart;
    }

    public Date getActualStart() {
        return actualStart;
    }

    public void setActualStart(Date actualStart) {
        this.actualStart = actualStart;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getRepairDesc() {
        return repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public Order setWage(){
        this.employee.getWage();
        return this;
    }

    public double getManhours() {
        return manhours;
    }

    public void setManhours(double manhours) {
        this.manhours = manhours;
    }

    @Override
    public String toString() {
        return "Order{" +
                "carAccepted=" + carAccepted +
                ", plannedStart=" + plannedStart +
                ", actualStart=" + actualStart +
                ", employee=" + employee +
                ", problemDesc='" + problemDesc + '\'' +
                ", repairDesc='" + repairDesc + '\'' +
                ", status=" + status +
                ", vehicle=" + vehicle +
                ", repairCost=" + repairCost +
                ", partsCost=" + partsCost +
                ", wage=" + wage +
                ", manhours=" + manhours +
                '}';
    }
}
