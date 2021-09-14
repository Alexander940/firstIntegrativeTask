package model;

public class Restaurant {

    private EmployeesInventory employeesInventory;

    public Restaurant() {
        this.employeesInventory = new EmployeesInventory();
    }

    public EmployeesInventory getEmployeesInventory() {
        return employeesInventory;
    }

    public void setEmployeesInventory(EmployeesInventory employeesInventory) {
        this.employeesInventory = employeesInventory;
    }
}
