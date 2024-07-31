package Validations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validations {


    @Test
    public void ValidationsGET() {


        RequestSpecification r = RestAssured.given();

        r.baseUri("http://localhost:3000");
        r.basePath("/students");


        Response response = r.when().get();


        Assert.assertEquals(response.getStatusCode(), 200);   // validations on response variable

        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");

        String s = response.jsonPath().get("[2].location");




        String s1 = response.jsonPath().get("[2].courses[1]");

        Assert.assertEquals(s, "Canada");
        Assert.assertEquals(s1, "RestAPI");


        Assert.assertEquals(response.statusCode(), 200);


    }
}
