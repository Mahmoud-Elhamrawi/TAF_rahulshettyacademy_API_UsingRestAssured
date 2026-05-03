package Models.De_Serolization.OrderDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisplayOderData {

    @JsonProperty("_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("orderById")
    public String getUserID() {
        return userID;
    }

    public String getOrderBy() {
        return orderBy;
    }
    @JsonProperty("productOrderedId")
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCountry() {
        return country;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getOrderPrice() {
        return orderPrice;
    }
    @JsonProperty("__v")
    public Integer getOrderVersion() {
        return orderVersion;
    }

    @JsonProperty("_id")
    private String orderId;

    @JsonProperty("orderById")
    private String userID;

    private String orderBy;

    @JsonProperty("productOrderedId")
    private String productID;

    private String productName;
    private String country;
    private String productDescription;
    private String productImage;
    private String orderPrice;

    @JsonProperty("__v")
    private Integer orderVersion;

}
