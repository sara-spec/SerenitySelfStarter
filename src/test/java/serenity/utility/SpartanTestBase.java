package serenity.utility;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBase {

    @BeforeAll
    public static void setUp() {
//54.82.85.146
        RestAssured.baseURI = "http://54.82.85.146:8000";
        RestAssured.basePath = "/api";
        // this is setting static field of rest assured class requestSpecification
        // to the value we specified,
        // so it become global evert test in this class can use it
//         RestAssured.authentication = basic("admin","admin");
    }
    @AfterAll
    public static void cleanUp(){
        SerenityRest.clear();
    }












}
