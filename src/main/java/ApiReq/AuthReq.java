package ApiReq;

import Models.Serolization.UserAuth;
import io.restassured.response.Response;

import static Routes.Endpoints.AUTH_LOGIN;
import static Specs.SpecReq.RegSpecAuth;
import static io.restassured.RestAssured.given;

public class AuthReq {


    public Response authRequest(UserAuth data) {

        return given()
                .spec(RegSpecAuth())
                .body(data)
                .when().post(AUTH_LOGIN)
                .then().log().all()
                .extract().response();


    }


}
