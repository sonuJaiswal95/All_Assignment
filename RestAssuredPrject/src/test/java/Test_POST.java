import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test_POST {
	//@Test
	public void test_1_post() {

		//		Map<String, Object> map = new HashMap<String, Object>();
		//		
		//		map.put("name", "sonu");
		//		map.put("job", "System Engineer");
		//		
		//		System.out.println(map);

		JSONObject request = new JSONObject();

		request.put("name", "sonu");
		request.put("job", "software engineer");
		System.out.println(request);

		given().
		header("content-type", "application/json").
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201);
	}
	@Test
	public void test_2_put() {


		JSONObject request = new JSONObject();

		request.put("name", "sonu");
		request.put("job", "software engineer");
		System.out.println(request);

		given().
		header("content-type", "application/json").
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
	//@Test
	public void test_3_patch() {


		JSONObject request = new JSONObject();

		request.put("name", "sonu");
		request.put("job", "software engineer");
		System.out.println(request);

		given().
		header("content-type", "application/json").
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
	//@Test
	public void test_4_delete() {


		
		when().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).
		log().all();
	}






}
