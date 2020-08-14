package Base    ;

import io.restassured.response.*;
import org.junit.Assert;


import static io.restassured.RestAssured.given;

public class BaseTest extends BasePage {
    public static String Search(){

        Response response = given()
                .param("apikey","b1d0fcb9")
                .param("s","Harry Potter")
                .get()
                .then()
                .statusCode(200).extract().response();

        int titleSize = Integer.parseInt(response.jsonPath().getString("Search.Title.size()"));

        String imdbId = null;

        for(int i = 0; i< titleSize-1;i++){
            String title = response.jsonPath().getString("Search.Title["+i+"]");

            if(title.contains("Harry Potter and the Sorcerer's Stone")) {

                imdbId = response.jsonPath().getString("Search.imdbID[" + i + "]");
                break;
            }
        }

        return imdbId;
    }
    public static void IdTitle(String imdbId){

        Response response = given()
                .param("apikey","b1d0fcb9")
                .param("i", imdbId)
                .get();

        Assert.assertEquals(200, response.getStatusCode());

        Assert.assertNotEquals(null,response.jsonPath().getString("Title"));
        System.out.println("Title of the movive: " + response.jsonPath().getString("Title"));

        Assert.assertNotEquals(null,response.jsonPath().getString("Year"));
        System.out.println("Release year of the movie: " + response.jsonPath().getString("Year"));

        Assert.assertNotEquals(null, response.jsonPath().getString("Released"));
        System.out.println("Release date of the movie: " + response.jsonPath().getString("Released"));
    }

}