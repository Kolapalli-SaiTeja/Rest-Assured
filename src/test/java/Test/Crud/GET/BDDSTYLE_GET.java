package Test.Crud.GET;

import io.restassured.RestAssured;

public class BDDSTYLE_GET {


    public static void main(String[] args) {



        // base URI  : https://reqres.in/
        // base path : /api/users/2


        RestAssured.given().baseUri("https://reqres.in/").basePath("/api/users/2")


                .when().get("https://reqres.in/api/users/2")

                .then().log().all().statusCode(200);


    }

}
