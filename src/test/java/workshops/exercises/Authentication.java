package workshops.exercises;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class Authentication {

	String url = "https://api.trello.com/1";
	String apiKey = "163dd77c54ff87891905e21954687c1a";//https://trello.com/app-key
	String token = "14f6119eced5f4498ffc17dd85729e69a1f0c505919d82d7d51ea8834ff364cd"; //https://trello.com/1/authorize?expiration=1day&name=SinglePurposeToken&key=REPLACE_WITH_YOUR_APIKEY

	/**
	 * Example: login with credentials
	 * 1) Populate parameters and post methods with proper values
	 * 2) Comment out header and print response
	 */
	public Response loginWithCredentials(String username, String password) {
		return  given()
				.baseUri(url)
				.header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
				.formParam("factors[user]", username)
				.formParam("factors[password]", password)
				.param("method", "password")
				.when().post("/authentication");
	}

	/** Example: testing the method
	 * 3) Check if status code is ok for valid credentials
	 * 4) Print the json response
	 * 5) Print value of selected field from json response
	 */
	@Test
	public void loginWithCredentialsPostiveTest() {
		loginWithCredentials("krisu876@wp.pl", "Fantasy12").then().statusCode(200);
	}

	@Test
	public void loginWithCredentialsNegativeTest() {
		//ToDo: add proper assertion here(then().statusCode()
		loginWithCredentials("krisu876@wp.pl", "tralala").then().statusCode(403);
	}

	@Test
	//ToDo add prettyPrint method here
	public void loginWithCredentialsPrintResponseTest() {
		loginWithCredentials("", "");
	}

	@Test
	//ToDo add proper field name here
	//hint: you can see the field name in previous test output.
	public void loginWithCredentialsPrintJsonFieldTest() {
		System.out.println(loginWithCredentials("krisu876@wp.pl", "Fantasy12")
				.jsonPath().getString("code"));
	}

	/**Exercise: login with api key methodFantasy12
	 * 1) Add parameter key with proper value
	 * 2) Add parameter token with proper value
	 * 3) Add endpoint /Members/me
	 */

	public Response authenticateWithApiKeyAndToken(String apiKey, String token) {
		//Todo: Add proper parameters for baseUri and get methods. Add proper values for key and token fields.
		return given()
				.baseUri(url+"/Members/me")
				.param( "key", apiKey)
				.param("token", token)
				.when().get("fullName");
	}

	/**Exercise: login with api key testing method
	 * 4) Add positive scenario: check if code 200 is returned when key and token are valid
	 * 5) Add negative scenario: check if code 401 is returned when key and token are invalid
	 */

	@Test
	public void authenticateWithApiTest() {
		//Todo: Add authenticateWithApiKeyAndToken method with proper parameters and assertions use
        authenticateWithApiKeyAndToken(apiKey, token).prettyPrint();
	}

	/**Exercise:
	 * Write request specification that will handle common parameters for given methods.
	 *
	 */

	public RequestSpecification requestSpecification(){

        return given()
                .baseUri(url)
                .param( "key", apiKey)
                .param("token", token);
	}

    public RequestSpecification postRequestSpecification(){

        return given()
                .baseUri(url)
                .contentType("application/json")
                .queryParam( "key", apiKey)
                .queryParam("token", token);
    }

	@Test
	public void displayDetailsAboutUser() {
		//ToDo: test request specification here. Print the response using prettyPrint method.
		given().spec(requestSpecification()).when().get("/Members/me").prettyPrint();
	}
}
