package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Api_chaining {


    RequestSpecification requestSpecification;

    String payload = "{\n" +
            "    \"firstname\" : \"krishna\",\n" +
            "    \"lastname\" : \"shiva\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    Response response;

    int id;

    String token;


    @Test
    public void PostFunction() {

        requestSpecification = RestAssured.given();

        // URL : https://restful-booker.herokuapp.com/booking
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(payload);
        requestSpecification.contentType(ContentType.JSON).log().all();


        response = requestSpecification.when().post();


        response.then().log().all();


        id = response.path("bookingid");

        System.out.println("The booking id is :" + id);

    }


    @Test(dependsOnMethods = {"PostFunction"})
    public void TokenPost() {


        String info = " {\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();

        // URL : https://restful-booker.herokuapp.com/booking
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.body(info);
        requestSpecification.contentType(ContentType.JSON).log().all();


        response = requestSpecification.when().post();


        response.then().log().all();


        token = response.path("token");

        System.out.println("The token id is :" + token);

    }

    @Test(dependsOnMethods = {"TokenPost"})
    public void PUTFunction() {


        String body = "{\n" +
                "    \"firstname\" : \"Rama\",\n" +
                "    \"lastname\" : \"seetha\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com").basePath("/booking/" + id);

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(body);
        requestSpecification.cookie("token", token);

        response = requestSpecification.when().put();

        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);

        v1.body("firstname", Matchers.equalTo("Rama"));

        assertThat("lastname").isNotEmpty();

        Assert.assertEquals("seetha", "seetha");

        String fs = response.path("firstname");


        System.out.println(fs);


        assertThat(fs).isNotEmpty();


    }


    @Test(dependsOnMethods = {"PUTFunction"})
    public void GetFunction() {


        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        requestSpecification.basePath("/booking/" + id);

        response = requestSpecification.when().get();


        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);

    }


    @Test(dependsOnMethods = {"GetFunction"})
    public void DeleteFunction() {


        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        requestSpecification.basePath("/booking/" + id);

        response = requestSpecification.when().get();


        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);


    }
}