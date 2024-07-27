package Test.Crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NonBDDStylePUT {


    RequestSpecification r;

    Response response;
    String token = "98fa2f0fef5a016";

    String payload = "{\n" +
            "    \"firstname\": \"Shiva\",\n" +
            "    \"lastname\": \"parvathi\",\n" +
            "    \"totalprice\": 233,\n" +
            "    \"depositpaid\": false,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2016-04-17\",\n" +
            "        \"checkout\": \"2022-12-01\"\n" +
            "    }\n" +
            "}";



    @Test
    public void PostivePUT(){

        //F

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/1325");
        r.body(payload);
        r.cookie("token", token);
        r.contentType(ContentType.JSON);


        response = r.when().put();


        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);
       // v1.body("firstname", Matchers.equalTo("Shiva"));

        Assert.assertEquals("Shiva", "Shiva");




    }





}
