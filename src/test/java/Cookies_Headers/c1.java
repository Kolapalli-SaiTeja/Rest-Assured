package Cookies_Headers;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class c1 {


    @Test
    public void cookie() {


        RequestSpecification r = RestAssured.given();

        r.baseUri("https://www.google.com/");

        Response response = r.when().get();

        String cookie = response.getCookie("AEC");


        Map<String, String> All_Cookies = response.getCookies();


        System.out.println( "Here it is man "+ All_Cookies.get("AEC")); // getting single cookie info

        Iterator<Map.Entry<String, String>> cs = All_Cookies.entrySet().iterator();

        while (cs.hasNext()) {

            System.out.println(cs.next());

        }



        ValidatableResponse rs = response.then().statusCode(200);

        rs.header("Content-Type", "text/html; charset=ISO-8859-1");
        rs.header("Server", "gws");

      //  rs.cookie("AEC", "cookies Keep on changing ");


        assertThat(200, equalTo(200));


    }



    @Test
    public void Header() {


        RequestSpecification r = RestAssured.given();

        r.baseUri("https://www.google.com/");

        Response response = r.when().get();

        String h = response.getHeader("Content-Type");

      Headers hs = response.getHeaders();

  // for every Headers there is key and value and type of Headers in Header   // Header   header name : value



        for (Header headers : hs){


            System.out.println(headers.getName()+ "  "+headers.getValue());

        }




        ValidatableResponse rs = response.then().statusCode(200).log().headers();

        rs.header("Content-Type", "text/html; charset=ISO-8859-1");
        rs.header("Server", "gws");

        //  rs.cookie("AEC", "cookies Keep on changing ");



        // here validating on response variable
        Assert.assertEquals(response.getStatusCode(),200);


        assertThat(200, equalTo(200));


    }


}
