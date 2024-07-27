package Test.Crud.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class NONBDD {


    public static void main(String[] args) {


      RequestSpecification r = RestAssured.given();



        r.baseUri("https://reqres.in/");
        r.basePath("/api/users/2").log().all();

        r.when().get();


        r.then().statusCode(400);





    }
}
