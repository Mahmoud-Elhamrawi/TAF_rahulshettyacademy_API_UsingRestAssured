package Models.Serolization;

import java.util.List;

public class list_orders {

    public list_orders(List<sub_order> orders) {
        this.orders = orders;
    }

    public list_orders() {
    }

    public List<sub_order> getOrders() {
        return orders;
    }

    List<sub_order> orders;

}
