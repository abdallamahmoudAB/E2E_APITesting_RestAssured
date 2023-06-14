package apiChaining;
import static io.restassured.RestAssured.*;


import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

    @Test
    void testGetUser(ITestContext context){
        int id = (int) context.getAttribute("user_id");
        String bearerToken = "7946549595c7a9cc54e595455e3d6652d5e07942b3f8b0af433efc5b4607ba69";


        given()

                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id", id)

                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log().all();

    }
}