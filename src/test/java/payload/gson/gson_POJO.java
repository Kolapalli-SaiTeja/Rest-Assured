package payload.gson;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.requestSpecification;

public class gson_POJO {

//    {
//        "firstname" :"Rama",
//            "lastname" :"seetha",
//            "totalprice" :111,
//            "depositpaid" :true,

//            "bookingdates" :
//          {
//        "checkin" :"2018-01-01",
//       "checkout" :"2019-01-01"
//    },
//        "additionalneeds" :"Breakfast"
//    }


    private String firstname;

    private String lastname;

    private  Integer totalprice;

    private Boolean depositpaid;

    private  String additionalneeds;







    @Test

    public void testcase1(){


        Bookings bookings = new Bookings();

        Faker faker = new Faker();

        bookings.setFirstname("Rama");
        bookings.setLastname("Seetha");
        bookings.setTotalprice(1000);
        bookings.setDepositpaid(false);


        Bookingdates bookingdates = new Bookingdates();

        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        bookings.setBookingdates(bookingdates);
        bookings.setAdditionalneeds("Lunch");


        Gson gson = new Gson();

        String jsonemp = gson.toJson(bookings);


        System.out.println(jsonemp);


       RequestSpecification requestSpecification = RestAssured.given();

        // URL : https://restful-booker.herokuapp.com/booking
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.body(bookings);
        requestSpecification.contentType(ContentType.JSON).log().all();


        Response response = requestSpecification.when().post();

        String     jsonresponsestring      =response.asString();

        Integer bookingID = response.then().extract().path("bookingid");

        System.out.println("Booking id is " + bookingID);


        ValidatableResponse vr =  response.then().log().all();
        vr.statusCode(200);
       // vr.body("firstname", Matchers.equalTo("Rama"));


      Bookings bookingresponseobj  =gson.fromJson(jsonresponsestring, Bookings.class);














    }




























}
