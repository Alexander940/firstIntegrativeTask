package model;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class manage all logic of the restaurant
 * @author Alexander Echeverry
 * @version 1.0
 */
public class Restaurant {

    //Singleton

    public static Restaurant instance;

    public static Restaurant getInstance(){
        if(instance == null){
            instance = new Restaurant();
        }
        return instance;
    }

    private EmployeesInventory employeesInventory;
    private IngredientsInventory ingredientsInventory;
    private Menu menu;
    private OrdersInventory ordersInventory;

    private Restaurant() {
        this.employeesInventory = new EmployeesInventory();
        this.ingredientsInventory = new IngredientsInventory();
        this.menu = new Menu();
        this.ordersInventory = new OrdersInventory();
    }

    /**
     * This return the employee's inventory
     * @return this contains the employee's inventory
     */
    public EmployeesInventory getEmployeesInventory() {
        return employeesInventory;
    }

    /**
     * this method will return an employee's inventory
     * @return this contains the ingredient's inventory
     */
    public IngredientsInventory getIngredientsInventory(){
        return ingredientsInventory;
    }

    /**
     * this method will return an instance of menu
     * @return this contains the ingredient's inventory
     */
    public Menu getMenu() {
        return menu;
    }

    public OrdersInventory getOrdersInventory(){
        return ordersInventory;
    }

    public void generateReportEmployees(){
        try {
            String report = generateTextReportEmployees();
            File file = new File("src/reports/employeesReport.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(report.getBytes());
            fos.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String generateTextReportEmployees(){
        String report = "Name - Orders num - Quantity sold\n";

        for(Employee employee: employeesInventory.getEmployees()){
            report += employee.getName() + " - " + employee.getNumOrders() + " - " + employee.getQuantitySold() + "\n";
        }

        return report;
    }

    public void generateReportSaucers(){
        try {
            String report = generateTextReportSaucers();
            File file = new File("src/reports/saucersReport.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(report.getBytes());
            fos.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String generateTextReportSaucers(){
        String report = "Name - Units sold - Quantity paid\n";
        int unitsSold = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String actualDate = dtf.format(LocalDateTime.now());


        for(Saucer saucer: menu.getSaucers()){
            for(int i = 0; i < saucer.getQuantitySold().size(); i++){
                if(saucer.getQuantitySold().get(i).getDate().equals(actualDate)){
                    unitsSold += saucer.getQuantitySold().get(i).getUnitsSold();
                }
            }
            report += saucer.getName() + " - " + unitsSold + " - " + (unitsSold* saucer.getPrice()) + "\n";
        }

        return report;
    }
}
