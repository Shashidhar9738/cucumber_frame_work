package Step_Defination;

import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.payloadconvertor;

public class Defination {

	public static String BaseURL = "https://simple-books-api.glitch.me";
	public static String Loginpayload;
	public static String createorderspayload;
	public static String ID;
	RequestSpecification requestSpecification;
	Response response;
	JsonPath jsonpath;
	public static String token;

	@Given("login to api")
	public void login_to_api() throws IOException {
		// this will help us to convert my request to string
		// request name is login.json
		Loginpayload = payloadconvertor.generatepayload("login.json");
		System.out.println(Loginpayload);

	}

	@When("Execute login {string} which provides accesstoken")
	public void execute_login_which_provides_accesstoken(String parameter) {

		requestSpecification = RestAssured.given().body(Loginpayload);
// in the below line im providing the body
		requestSpecification.contentType(ContentType.JSON);
		// so the below code will send the request and collect the response in the
		// response variable
		response = requestSpecification.post(BaseURL + parameter);

	}

	@Then("verify the status code {int}")
	public void verify_the_status_code(Integer statuscode) {

		Assert.assertEquals(statuscode, response.getStatusCode());

	}

	@Then("verify the access token is fetched")
	public void verify_the_access_token_is_fetched() {

		jsonpath = new JsonPath(response.getBody().asString());
		token = jsonpath.get("accessToken");
		System.out.println("accessToken = "+token);

	}

//Second one

	@Given("login successfull with accessToken")
	public void login_successfull_with_accessToken() throws IOException {
		// this will help us to convert my request to string
		// request name is login.json
		createorderspayload = payloadconvertor.generatepayload("createorders.json");
		System.out.println(createorderspayload);

	}

	@When("order a book {string} and fetch the order id")
	public void order_a_book_and_fetch_the_order_id(String string) {
		requestSpecification = RestAssured.given().body(createorderspayload);
		// in the below line im providing the body
		requestSpecification.contentType(ContentType.JSON);
		// adding the authorization tokens with the key words "Bearer "

		requestSpecification.header("Authorization", "Bearer " + token);

		// so the below code will send the request and collect the response in the
		// response variable
		response = requestSpecification.post(BaseURL + string);

		
	}

	@Then("Verify the Status code is {int}")
	public void verify_the_status_code_is(Integer int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}

	@Then("verify the order id from the response")
	public void verify_the_order_id_from_the_response() {

		jsonpath = new JsonPath(response.getBody().asString());
		ID = jsonpath.get("orderId");
		System.out.println("orderId = "+ID);

	}

}
