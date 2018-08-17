package pl.coderslab.entity;

import java.time.LocalDate;

public class Customer extends Person {
    private LocalDate birthday;

    public Customer() {
    }
    public Customer(String name, String surname, String phone, String adress, LocalDate birthday) {
        super(name, surname, phone, adress);
        this.birthday = birthday;
    }

    public Customer(int id, String name, String surname, String phone, String adress, LocalDate birthday) {
        super(id, name, surname, phone, adress);
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "birthday=" + birthday +
                '}';
    }
}
