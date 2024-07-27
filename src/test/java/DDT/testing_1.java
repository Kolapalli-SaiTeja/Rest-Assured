package DDT;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testing_1 {


    //https://reqres.in/

    //URI : "https://reqres.in"
    //
    // "/api/users"


    @Test
    public void GETBookings() {


        RequestSpecification r = RestAssured.given();

        r.baseUri("https://reqres.in");
        r.basePath("/api/users");


        Response response = r.when().post();


        Assert.assertEquals(response.statusCode(), 200);


        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);

//        v1.body("firstname", Matchers.equalTo("krishna"));
    }
}