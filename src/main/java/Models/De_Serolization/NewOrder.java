package Models.De_Serolization;

import java.util.List;

public class NewOrder {

    public String getMessage() {
        return message;
    }

    public List<String> getProductOrderId() {
        return productOrderId;
    }

    public List<String> getOrders() {
        return orders;
    }

    private List<String> orders;
    private List<String> productOrderId;
    private String message;


}
