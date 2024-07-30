package payload.Hashmap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class Payload_Hashmap {


   /* {
        "firstname" : "Rama",
            "lastname" : "seetha",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
        "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
    },
        "additionalneeds" : "Breakfast"
    }
*/


    @Test
    public void testPostReq() {


        Map<String, Object> Payload_hashmap = new LinkedHashMap<>();

        Faker faker = new Faker();

        Payload_hashmap.put("firstname", "Rama");
        Payload_hashmap.put("lastname", faker.name().lastName());
        Payload_hashmap.put("totalprice", 122);
        Payload_hashmap.put("depositpaid", faker.random().nextBoolean());
        Payload_hashmap.put("additionalneeds", faker.random().toString());


        Map<String, Object> bookingDates = new HashMap<>();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");


        Payload_hashmap.put("bookingdates", bookingDates);


        requestSpecification = RestAssured.given();

        // URL : https://restful-booker.herokuapp.com/booking
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(Payload_hashmap);


        Response response = requestSpecification.when().post();

        Integer bookingID = response.then().extract().path("bookingid");

        System.out.println("Booking id is " + bookingID);


        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);


        vr.body("booking.totalprice", equalTo(122));
        vr.body("booking.bookingdates.checkin", equalTo("2018-01-01"));

    }

}
