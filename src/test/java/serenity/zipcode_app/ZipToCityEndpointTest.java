package serenity.zipcode_app;


import io.restassured.RestAssured;
import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.is;

@SerenityTest
public class ZipToCityEndpointTest {

    //https://api.zippopotam.us/{{country}}/{{zipcode}}

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://api.zippopotam.us" ;
    }
    @AfterAll
    public static void cleanUp(){
        clear();
    }


    @DisplayName("Testing 1 zip code and get the result")
    @Test
    public void test1ZipCode(){

        given()
                .pathParam("country","us")
                .pathParam("zipcode","22030").
                when()
                .get("/{country}/{zipcode}").
                then()
                .statusCode(200)
                .body("'post code'",is("22030") )
                .body("places[0].'place name'", is("Fairfax")
                ) ;
    }


}
