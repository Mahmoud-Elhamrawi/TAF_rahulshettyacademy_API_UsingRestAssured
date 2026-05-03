package Models.De_Serolization.OrderDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderData {

    @JsonProperty("data")
    private DisplayOderData DisplayOderData;

    public String getMessage() {
        return message;
    }

    @JsonProperty("data")
    public DisplayOderData getDisplayOderData() {
        return DisplayOderData;
    }

    private String message;

}
