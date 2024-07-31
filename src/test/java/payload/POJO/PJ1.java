package payload.POJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class PJ1 {

    // Wrapping of variables and methods into one single class - encapsulation
    // Here we use getters and setters > to create the data

//    {
//        "id": 1,
//            "name": "John",
//            "location": "india",
//            "phone": "1234567890",
//            "courses": [
//        "Java",
//                "Selenium"
//    ]
//    }


    int id;

    @Test
    public void testPUT() {


        pj2 data = new pj2();

        data.setName("Rama");
        data.setLocation("Ayodhya");
        data.setPhone("64010022323");

        String[] courses = {"java", "C++"};

        data.setCourses(courses);

        requestSpecification = RestAssured.given();



        //URL : http://localhost:3000/students

        requestSpecification.contentType("application/json");
        requestSpecification.body(data);


        Response response = requestSpecification.when().post("http://localhost:3000/students");

        id = response.then().extract().path("id");

        System.out.println("id is " + id);












    }

    @Test (priority = 1)
    public void Delete() {


        RestAssured.given()

        //URL : http://localhost:3000/students



       .when().delete("http://localhost:3000/students/" +id)
        .then().log().all();



    }
}