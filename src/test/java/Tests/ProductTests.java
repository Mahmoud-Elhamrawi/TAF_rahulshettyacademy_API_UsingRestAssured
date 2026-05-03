package Tests;

import Models.De_Serolization.NewOrder;
import Models.De_Serolization.NewProduct;
import Models.De_Serolization.OrderDetails.OrderData;
import Models.De_Serolization.UserLogin;
import Models.Serolization.list_orders;
import Models.Serolization.sub_order;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static ApiReq.ProductReq.*;
import static Routes.Msg.*;
import static Steps.UserSteps.getUserID;
import static Steps.productSteps.*;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature("Product Tests")
public class ProductTests {

    @Story("create new product test case")
    @Test(description = "create new product test case with valid data")
    public void validCreateNewProductTC() {
        String productImage = System.getProperty("user.dir") + "/src/test/resources/Data/625.jpg";
        String userID = getUserID();

        //req
        Response res = createNewProductReq(productData(userID), productImage);

        //de-ser
        NewProduct returnedNewProduct = res.body().as(NewProduct.class);

        //assert
        Assert.assertEquals(returnedNewProduct.getMessage(), CREATE_PRODUCT_SUCCESS);
        assertThat(returnedNewProduct.getProductId(), not(equalTo(null)));

    }


    @Story("create new order test case")
    @Test(description = "create new order test case with valid data")
    public void validCreateNewOrderTC() {
        String productID = getProductID();


        sub_order order = createOrderData(productID);

        List<sub_order> orderList = new ArrayList<>();
        orderList.add(order);

        list_orders orders = new list_orders(orderList);


        //req
        Response res = createNewOrderReq(orders);
        res.prettyPrint();
        System.out.println(res.statusCode());
        System.out.println(res.getContentType());
        //de-ser
        NewOrder returnedNewOrder = res.body().as(NewOrder.class);

        //assert
        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertEquals(returnedNewOrder.getProductOrderId().getFirst(), productID);
        Assert.assertEquals(returnedNewOrder.getMessage(), PLACED_ORDER_SUCCESS);
        assertThat(returnedNewOrder.getOrders().getFirst(), not(equalTo(null)));
    }



@Story("get order details test case")
    @Test(description = "get order details test case")
    public void validGetOrderDetailsTC() {

        String orderID = getOrderID();
        System.out.println(orderID);

        //req
        Response res = getOrderDetailsReq(orderID);


        res.prettyPrint();
        System.out.println(res.statusCode());
        System.out.println(res.getContentType());

        //de-ser

        OrderData returnedOrderData = res.body().as(OrderData.class); //OrderData
        //assert
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(returnedOrderData.getMessage(), GET_ORDER_SUCCESS);
        Assert.assertEquals(returnedOrderData.getDisplayOderData().getOrderId(), orderID);
        Assert.assertEquals(returnedOrderData.getDisplayOderData().getUserID(), getUserID());
        assertThat(returnedOrderData.getDisplayOderData().getOrderVersion(), not(equalTo(null)));
        assertThat(returnedOrderData.getDisplayOderData().getOrderPrice(), not(equalTo(null)));
    }



    @Story("delete product test case")
    @Test(description = "delete product test case")
    public void validDeleteProductTC() {
        String productID = getProductID();

        //req
        Response res = deleteOrderReq(productID);

        //de-ser
        UserLogin returnedMessage = res.body().as(UserLogin.class);

        //assert
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(returnedMessage.getMessage(), DELETE_PRODUCT_SUCCESS);
    }




    @Story("delete the same product test case")
    @Test(description = "delete the same product test case")
    public void inValidDeleteSameProductTC() {
        String productID = getProductID();

        //req
        Response res = deleteOrderReq(productID);
        Response res1 = deleteOrderReq(productID);

        //de-ser
        UserLogin returnedMessage = res1.body().as(UserLogin.class);

        //assert
        Assert.assertEquals(res1.statusCode(), 400);
        Assert.assertEquals(returnedMessage.getMessage(), DELETE_SAME_PRODUCT_ERROR);
    }

}
