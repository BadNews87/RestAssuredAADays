package workshops.exercises;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class PutRequests {

	Authentication authentication = new Authentication();

	/**
	 * Exercise 1: create a method to change cardName
	 *
	 */

	//ToDo: Add proper parameters and endpoint. See trello documentation for details
	public Response changeCardName() {
		return given()
				.specification(authentication.postRequestSpecification())
				.queryParam("", "")
				.when()
				.put("/cards");
	}

	@Test
	public void changeCardNameTest() {
		//ToDo: test changeCardName method here
	}

	/**
	 * Exercise 2: create a method to move card to other list;
	 *
	 */
	//ToDo: Add proper parameters and endpoint. See trello documentation for details
	public Response moveCardToOtherList() {
		return given()
				.queryParam("", "")
				.when()
				.put("");
	}

	@Test
	public void moveCardToOtherListTest() {
		//ToDo: test moveCardToOtherList method here;
	}

}
