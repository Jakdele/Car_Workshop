package pl.coderslab.entity;

public class Employee extends Person {
    private String note;
    private double wage;

    public Employee() {
    }

    public Employee(String name, String surname, String phone, String address, String note, double wage) {
        super(name, surname, phone, address);
        this.note = note;
        this.wage = wage;
    }

    public Employee(int id, String name, String surname, String phone, String adress, String note, double wage) {
        super(id, name, surname, phone, adress);
        this.note = note;
        this.wage = wage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "note='" + note + '\'' +
                ", wage=" + wage +
                '}';
    }
}
