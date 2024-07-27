package Test.Crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class NonBDDStylePOST {




    String Bodyinfo = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

@Test
    void positivePOST(){


        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.body(Bodyinfo);
        r.contentType(ContentType.JSON).log().all();


        Response response = r.when().post();


        ValidatableResponse v1 = response.then().log().all();

        v1.statusCode(200);

    Assert.assertEquals("James", "James");



    }




}
