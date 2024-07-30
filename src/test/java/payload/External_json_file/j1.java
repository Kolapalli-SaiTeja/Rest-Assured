package payload.External_json_file;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class j1 {



    @Test
void POSTusingExternalJSON() throws FileNotFoundException {



     File file = new File("C:\\Users\\Lycan\\IdeaProjects\\RestAPI\\BODY.JSON"); // FILE


   FileReader fileReader = new FileReader(file);// FILE READER


    JSONTokener jsonTokener = new JSONTokener(fileReader);  //import.org.json


    JSONObject data = new JSONObject(jsonTokener);


    requestSpecification = RestAssured.given();

    //URL : http://localhost:3000/students

    requestSpecification.baseUri("http://localhost:3000");
    requestSpecification.basePath("/students");
    requestSpecification.contentType("application/json");
    requestSpecification.body(data.toString());


    Response response = requestSpecification.when().post();



    ValidatableResponse vr = response.then().log().all();
    vr.statusCode(201);

    vr.body("name", equalTo("Rama"));
    vr.body("courses[0]", equalTo("java"));
    vr.body("courses[1]", equalTo("C++"));

}

}
