package Models.Serolization;

public class sub_order {

    public String getCountry() {
        return country;
    }

    public String getProductOrderedId() {
        return productOrderedId;
    }

    private String country;
    private String productOrderedId;

    public sub_order() {

    }
    public sub_order(String country, String productOrderedId) {
        this.country = country;
        this.productOrderedId = productOrderedId;
    }


}
