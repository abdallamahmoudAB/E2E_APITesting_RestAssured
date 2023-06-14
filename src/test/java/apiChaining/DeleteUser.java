package apiChaining;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class DeleteUser {

    @Test
    void testDeleteUser(ITestContext context){

        int id = (int) context.getAttribute("user_id");
        String bearerToken = "7946549595c7a9cc54e595455e3d6652d5e07942b3f8b0af433efc5b4607ba69";

        given()

                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id", id)

                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(204)
                .log().all();

    }
}

