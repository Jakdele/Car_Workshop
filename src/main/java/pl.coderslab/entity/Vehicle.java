package pl.coderslab.entity;

import java.time.LocalDate;

public class Vehicle {
    private Integer id;
    private String make;
    private String model;
    private Integer manufactured;
    private String regNumber;
    private LocalDate nextReview;
    private Customer owner;

    public Vehicle() {
    }

    public Vehicle(String make, String model, Integer manufactured, String regNumber, LocalDate nextReview, Customer owner) {
        this.make = make;
        this.model = model;
        this.manufactured = manufactured;
        this.regNumber = regNumber;
        this.nextReview = nextReview;
        this.owner = owner;
    }

    public Vehicle(int id, String make, String model, Integer manufactured, String regNumber, LocalDate nextReview, Customer owner) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.manufactured = manufactured;
        this.regNumber = regNumber;
        this.nextReview = nextReview;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufactured() {
        return manufactured;
    }

    public void setManufactured(Integer manufactured) {
        this.manufactured = manufactured;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getNextReview() {
        return nextReview;
    }

    public void setNextReview(LocalDate nextReview) {
        this.nextReview = nextReview;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
