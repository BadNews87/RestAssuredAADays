package workshops.exercises;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;

public class PostRequests {

	Authentication authentication = new Authentication();
	private String myBoardName = "AADays";
	private String myCardName = "Perform Card";
	private String listId = "58dcbc66eef56cde5641cbf7";
	/**
	 * Exercise 1: Create new Board.
	 *
	 */

	public Response createBoard(String boardName) {
		//ToDo: add authentication and proper parameters.
		// Hint: use trello documentation to check endpoint details.
		return given()
				.specification(authentication.postRequestSpecification())
				.queryParam("name", boardName)
				.when().post("/boards");
	}

	@Test
	public void createBoardTest() {
		//ToDo: use createBoard method here
		createBoard(myBoardName);
	}

	/**
	 * Exercise 2: Create new card on board
	 *
	 */

	//ToDo: create and test createCard method.
	//Hint: use trello documentation. You might need 2 arguments for createCard method.

	public Response createCard(String cardName, String idList) {
		//ToDo: add authentication and proper parameters.
		// Hint: use trello documentation to check endpoint details.
		return given()
				.specification(authentication.postRequestSpecification())
				.queryParam("name", cardName)
				.queryParam("idList",idList )
				.when().post("/cards");
	}

	@Test
	public void createCardTest() {
		//ToDo: use createBoard method here
		createCard(myCardName, listId);
	}


	/**\
	 * Exercise 3: Create new list
	 *
	 */

	//ToDo: create and test createList method.
	//Hint: use trello documentation and use 2 arguments

}
