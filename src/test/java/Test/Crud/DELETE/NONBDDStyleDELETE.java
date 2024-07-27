package Test.Crud.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NONBDDStyleDELETE {


    String token = "98fa2f0fef5a016";

    @Test
    public void PositiveDelete(){

        RequestSpecification r = RestAssured.given();



        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/3023");
        r.contentType(ContentType.JSON);
        r.cookie("token", token);


        Response response = r.when().delete();


        ValidatableResponse v = response.then().log().all();

        v.statusCode(201);

    }



}
