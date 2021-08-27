import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test02_GET {
	@Test
	public void test_1() {
		
		given().
			header("content-type", "application/json").
	
			get("https://reqres.in/api/users?page=2").andReturn().
		then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).
			body("data.first_name", hasItems("Michael", "Lindsay")).
			log().body();
	}

}
