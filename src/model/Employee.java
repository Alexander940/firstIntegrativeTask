package model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private String dateOfBirth;
    private String password;

    public Employee(String name, String id, String dateOfBirth, String password) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String output;

        output = "name: " + name + "\n" +
                 "id: " + id + "\n" +
                 "date of birth: " + dateOfBirth + "\n" +
                 "password: " + password + "\n";

        return output;
    }
}
