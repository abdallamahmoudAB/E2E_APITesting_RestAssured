package apiChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class UpdateUser {

    @Test
    void testUpdateUser(ITestContext context){

        Faker faker = new Faker();

        JSONObject data = new JSONObject();

        data.put("name", faker.name().firstName());
        data.put("gender", "male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");


        String bearerToken = "7946549595c7a9cc54e595455e3d6652d5e07942b3f8b0af433efc5b4607ba69";
        int id = (int) context.getAttribute("user_id");

        given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .pathParam("id", id)
                .body(data.toString())

                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log().all();


    }

}