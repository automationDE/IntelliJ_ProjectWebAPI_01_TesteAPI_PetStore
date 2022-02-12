// Packages
package Teste_API_PetStore;

// Libraries
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


// Classes
public class PetStore {
    // Attributes
    String uri = "https://petstore.swagger.io/v2/pet";  // Adress entity test

    // Methode and functions
    public String lerJson(String pathJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(pathJson)));
    }

    // Include - create - post
    @Test // Identify the method or function as a testing for the TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("Data/Pet1.json");

        // Sintaxe Gherkin
        // Data - When - Then
        given()
                .contentType("application/json") // common in API REST - old age "text/xml"
                .log().all() // preparacao para registrar o envio (REQUEST)
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all() // preparacao para registrar a volta (RESPONSE)
                .statusCode(200)
        ;
        System.out.println();
        System.out.println("Inclusao de Pet realizada com sucesso!");
    }

}
