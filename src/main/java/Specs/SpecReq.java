package Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecReq {
    public static RequestSpecification RegSpecAuth() {
        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setBasePath("/api/ecom/auth")
                .setContentType(ContentType.JSON)
                .build();
    }

    //{{baseURL}}/api/ecom/product/delete-product/69f73c7cf86ba51a659d7f74
    public static RequestSpecification reqSpecCreteProd() {
        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setBasePath("/api/ecom/product")
                .build();
    }

    public static RequestSpecification reqSpecCreateOrder() {

        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setBasePath("/api/ecom/order")
                .setContentType(ContentType.JSON)
                .build();
    }

//{{baseURL}}/api/ecom/product/delete-product/69f73c7cf86ba51a659d7f74
    // api/ecom/order/get-orders-details?id={{orderID}}
    public static RequestSpecification reqSpecGetOrderDetails() {

        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setBasePath("/api/ecom/order")
                .setContentType(ContentType.JSON)
                .build();
    }


}
