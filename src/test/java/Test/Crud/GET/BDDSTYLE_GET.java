package Test.Crud.GET;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class BDDSTYLE_GET {


    public static void main(String[] args) {



        // base URI  : https://reqres.in/
        // base path : /api/users/2


        RestAssured.given()


                .when().get("https://reqres.in/api/users?page=2")

                .then().body("page", equalTo(2)).log().all();


    }

}
