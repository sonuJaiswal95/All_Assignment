package StepDefinitions;
    import org.testng.Assert;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;

	public class Scenario2 {
		Response r;
		String api;
		

		@Given("API4 for foreign exchange incorrect url")
		public void api4_for_foreign_exchange_incorrect_url() {
			 api ="http://api.exchangeratesapi.io/v1/latest?access_key=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";
			
		    // Write code here that turns the phrase above into concrete actions
		}  

		@When("Posted with incorrect info url")
		public void posted_with_incorrect_info_url() {
			r =  RestAssured.given().when().log().all().get(api).then().extract().response();
			System.out.println(r.asString());
		    // Write code here that turns the phrase above into concrete actions
			//System.out.println(StatusCode, 400);
		}   

		@Then("Validate positive response error code recieved in request")
		public void validate_positive_response_error_code_recieved_in_request() {
		    // Write code here that turns the phrase above into concrete actions

			//System.out.println(r.asPrettyString());
					JsonPath jp = r.jsonPath();
					Float f = jp.get("rates.AMD");
					System.out.println(f);
					String s = jp.get("error.code");
					//System.out.println(s);
					
					Assert.assertEquals(s , "invalid_access_key"); 
				    
				}

			

			
		    
		}


