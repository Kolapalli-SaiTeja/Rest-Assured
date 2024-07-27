package Test.Crud.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GETnonBDDTestNG {



    //full url : https://restful-booker.herokuapp.com/booking/2769

    @Test
    public void GETallPositiveBookings(){


        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/3246");


        Response response = r.when().get();


        Assert.assertEquals(response.statusCode(), 200);


        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);

        v1.body("firstname", Matchers.equalTo("krishna"));

       // Assert.assertEquals("krishna","krishna" );

       // v1.body("firstname", equalTo("Arjshna"));


    }

//    @Test
//    public void GETallNegativeBookings(){
//        RequestSpecification r = RestAssured.given();
//
//
//
//        r.baseUri("https://reqres.in/");
//        r.basePath("/api/users/-1").log().all();
//
//        r.when().get();
//
//
//        r.then().statusCode(404);
//    }
//
//    @Test
//    public void GETallNegative1Bookings(){
//        RequestSpecification r = RestAssured.given();
//
//
//
//        r.baseUri("https://reqres.in/");
//        r.basePath("/api/users/ab2").log().all();
//
//        r.when().get();
//
//
//        r.then().statusCode(201);
//    }

}
