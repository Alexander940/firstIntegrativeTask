package model;

<<<<<<< HEAD
    public class Order {
=======
import java.util.ArrayList;
>>>>>>> fa87e78bbdb099a476352ecd221eb99e2829323d

    String uId;
    String state;
    String date;
<<<<<<< HEAD



=======
    ArrayList<ArrayList<String>> saucers;

>>>>>>> fa87e78bbdb099a476352ecd221eb99e2829323d
    public Order(String uId,String state,String date){
        this.date = date;
        this.state = state;
        this.uId = uId;
<<<<<<< HEAD

=======
>>>>>>> fa87e78bbdb099a476352ecd221eb99e2829323d
    }

    public void setState(String state) {
        this.state = state;
    }

}
