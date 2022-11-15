package edu.practice.api.tests;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static edu.practice.api.utils.Utility.getSchemaValidationPath;
import static edu.practice.api.utils.Utility.matchSchema;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import edu.practice.api.pojos.Person;

public class UsersTest extends BaseApiTest {
	Person person = null;
	String personJson = null;
	
	
	@Test(priority=1)
	public void testCreateUserApi() {
		person = new Person();
		personJson = person.generatePersonData();
		Response response = given().relaxedHTTPSValidation()
				.contentType("application/json")
				.body(personJson)
				.post("users");
		print(response.asPrettyString());
		response.then().statusCode(201);
		response.then().assertThat().body(matchSchema("create-user-schema.json"));
	}

	@Test(priority=2)
	public void testSingleUserApi() {
		Response response = given().relaxedHTTPSValidation()
				.get("users/"+person.getId());
		response.then().statusCode(200);
		print(response.asPrettyString());
		response.then().assertThat().body(matchSchema("single-user-schema.json"));
		
		Response response2 = given().relaxedHTTPSValidation().get("users/23");
		print(response2.asPrettyString());
		response2.then().statusCode(404);
	}
	
	@Test(priority=3)
	public void testListUsersApi() {
		Response response = given().relaxedHTTPSValidation().param("page", "2").get("users/");
		print(response.asPrettyString());
		response.then().statusCode(200);
		response.then().assertThat().body(matchSchema("list-users-schema.json"));
	}
}
