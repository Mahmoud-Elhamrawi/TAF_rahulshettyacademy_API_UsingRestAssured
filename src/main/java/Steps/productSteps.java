package Steps;

import ApiReq.ProductReq;
import Models.De_Serolization.NewOrder;
import Models.De_Serolization.NewProduct;
import Models.Serolization.list_orders;
import Models.Serolization.sub_order;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ApiReq.ProductReq.createNewOrderReq;
import static ApiReq.ProductReq.createNewProductReq;
import static Steps.UserSteps.getUserID;

public class productSteps {
    public static Map<String, Object> productData(String userID) {
        Map<String, Object> productData = new HashMap<>();
        productData.put("productName", "Laptop");
        productData.put("productAddedBy", userID);
        productData.put("productCategory", "Dell");
        productData.put("productSubCategory", "Dell hp");
        productData.put("productPrice", "50000");
        productData.put("productDescription", "Laptop top of the world");
        productData.put("productFor", "all people");
        return productData;

    }


    public static sub_order createOrderData(String productID) {

        return new sub_order("India", productID);
    }


    public static String getProductID() {
        String productImage = System.getProperty("user.dir") + "/src/test/resources/Data/auc2.jpeg";
        String userID = getUserID();

        Response res = createNewProductReq(productData(userID) ,productImage);

        return res.body().as(NewProduct.class).getProductId();
    }



    public static String getOrderID() {
        String productID = getProductID();


        sub_order order = createOrderData(productID);

        List<sub_order> ordersList = new ArrayList<>();
        ordersList.add(order);

        list_orders orderList1 = new list_orders(ordersList);


        Response res = createNewOrderReq(orderList1);
        return res.body().as(NewOrder.class).getOrders().getFirst();
    }




}
