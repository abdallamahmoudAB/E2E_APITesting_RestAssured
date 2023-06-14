package apiChaining;

import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateUser {

    @Test
    void testCreateUser(ITestContext context){

        Faker faker = new Faker();

        JSONObject data = new JSONObject();

        data.put("name", faker.name().firstName());
        data.put("gender", "male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "active");


        String bearerToken = "7946549595c7a9cc54e595455e3d6652d5e07942b3f8b0af433efc5b4607ba69";
        int userid = given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://gorest.co.in/public/v2/users/")
                .jsonPath().getInt("id");

        System.out.println("Generated id is: "+userid);

        // for test level
        context.setAttribute("user_id", userid);

        // for suite level
//        context.getSuite().setAttribute("user_id", userid);


    }
}
