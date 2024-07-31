package Serialization_DeSerialization;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class sd1 {





//@Test
    void convertPOJOtoJSON() throws Exception {



        student stuPOJO = new student();

        stuPOJO.setName("Rama");
        stuPOJO.setLocation("Ayodhya");
        stuPOJO.setPhone("64010022323");

        String[] courses = {"java", "C++"};

        stuPOJO.setCourses(courses);


        //Converting JAVA object ------>> Json Object (Serilization)

        ObjectMapper obm = new ObjectMapper();


       String jsondata = obm.writerWithDefaultPrettyPrinter().writeValueAsString(stuPOJO);

        System.out.println(jsondata);




    }
    // JSON ---->POJO
    @Test
    public void convertJSONtoPOJO() throws Exception{



    String data = "{\"name\": \"John\",\n" +
            "      \"location\": \"india\",\n" +
            "      \"phone\": \"1234567890\",\n" +
            "      \"courses\": [\n" +
            "        \"Java\",\n" +
            "        \"Selenium\"\n" +
            "      ]\n" +
            "    }";


    //Converting JSON data ---------->>>>> POJO OBJECT


        ObjectMapper obm = new ObjectMapper();

    student jsonPOJO = obm.readValue(data, student.class); // JSON TO POJO

        System.out.println(jsonPOJO.getName());
       System.out.println (jsonPOJO.getCourses()[1]);
        System.out.println (jsonPOJO.getCourses()[0]);
        System.out.println(jsonPOJO.getLocation());
        System.out.println(jsonPOJO.getPhone());




    }





}
