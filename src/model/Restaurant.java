package model;

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
}
