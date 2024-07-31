package Validations;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class validation2 {

    @Test
    public void JsonpathValidation() {


        // URL : http://localhost:3000/book

        RequestSpecification r = RestAssured.given();

        r.contentType(ContentType.JSON);

        Response response = r.when().get("http://localhost:3000/store");

      String title =   ( response.jsonPath().get("book[0].title"));

        System.out.println("The title here is >>>>>### " +title);


        JSONObject jsonObject = new JSONObject(response.asString());  // coming from org,json dependency

        boolean status = false;

        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {

            String booktitle = jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();


            // System.out.println("The Book Title is " + booktitle);   //Ramayana

            if (booktitle.equals("Ramayana")) {


                status = true;
                break;
            }
        }

        Assert.assertEquals(status, true);


        // Another validation if we want count of all years combined

        double totalprice =0;


        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {

            String year = jsonObject.getJSONArray("book").getJSONObject(i).get("year").toString();


            totalprice = totalprice + Double.parseDouble(year);

        }

        System.out.println(totalprice);




    }

}
