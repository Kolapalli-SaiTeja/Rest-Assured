package Validations;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class jsonSchema_Validations {



    @Test
void schemaValidation(){


    RequestSpecification requestSpecification = RestAssured.given();

// http://localhost:3000/store
    requestSpecification.baseUri("http://localhost:3000");
    requestSpecification.basePath("/store");


    Response response = requestSpecification.when().get();


    ValidatableResponse vr = response.then();
    vr.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StudentJSON.json"));



}



}
