package payload.Hashmap;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class JsonObject_Payload {




    @Test
    public void testPostReq() {

        JSONObject data = new JSONObject();


        Faker faker = new Faker();

        data.put("firstname", "Rama");
        data.put("lastname", faker.name().lastName());
        data.put("totalprice", 122);
        data.put("depositpaid", faker.random().nextBoolean());
        data.put("additionalneeds", faker.random().toString());

        JSONObject data1 = new JSONObject();


        data1.put("checkin", "2018-01-01");
        data1.put("checkout", "2019-01-01");


        data.put("bookingdates", data1);


        requestSpecification = RestAssured.given();

        // URL : https://restful-booker.herokuapp.com/booking
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(data.toString());


        Response response = requestSpecification.when().post();

        Integer bookingID = response.then().extract().path("bookingid");

        System.out.println("Booking id is " + bookingID);


        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);


        vr.body("firstname", equalTo("Rama"));
        vr.body("booking.totalprice", equalTo(122));
        vr.body("booking.bookingdates.checkin", equalTo("2018-01-01"));

    }

}
