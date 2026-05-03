package Tests;

import ApiReq.AuthReq;
import Models.De_Serolization.UserLogin;
import Models.Serolization.UserAuth;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.jackson.databind.ObjectMapper;

import static Routes.Msg.LOGIN_ERROR;
import static Routes.Msg.LOGIN_SUCCESS;
import static Steps.UserSteps.createInValidUserData;
import static Steps.UserSteps.createUserData;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature("User Tests")
public class UserTests {


    @Story("valid login test case")
    @Test(description = "valid login test case")
    public void validLoginTC() {
        UserAuth userData = createUserData();
        System.out.println(new ObjectMapper().writeValueAsString(userData));


        //Req
        Response res = new AuthReq().authRequest(userData);

        res.prettyPrint();
        System.out.println(res.getStatusCode());
        System.out.println(res.getContentType());


        //De-ser
        UserLogin returnedLoginData = res.body().as(UserLogin.class);

        //Assert
        assertThat(res.statusCode(), equalTo(200));
        assertThat(returnedLoginData.getToken(), not(equalTo(null)));
        assertThat(returnedLoginData.getUserId(), not(equalTo(null)));
        Assert.assertEquals(returnedLoginData.getMessage(), LOGIN_SUCCESS);

    }



    @Story("inValid login test case with invalid data")
    @Test(description = "inValid login test case with invalid data")
    public void inValidLoginTC() {
        UserAuth userData = createInValidUserData();

        //Req
        Response res = new AuthReq().authRequest(userData);

        //De-ser
        UserLogin returnedLoginData = res.body().as(UserLogin.class);

        //Assert
        assertThat(res.statusCode(), equalTo(400));
        Assert.assertEquals(returnedLoginData.getMessage(), LOGIN_ERROR);

    }


}
