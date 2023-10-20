package api001;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class req01 {
@Test
	
	public void get()
	{
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7));//get method
		
	}
//@Test
public void post()
{
	JSONObject js =new JSONObject();
	js.put("name", "morpheus");
	js.put("job","leader");
	System.out.println(js.toJSONString());
	given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();//create
	
			

}
//@Test
public void put()
{
	HashMap<String,Object> additionalDetails=new HashMap<String,Object>();
	 additionalDetails.put("name", "morpheus");
	 additionalDetails.put("job","leader");
	 JSONObject additionalDetailsJSON =new JSONObject(additionalDetails);
	 given().body(additionalDetailsJSON.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();//update
	
}
//@Test 
public void delete()
{
	given().delete("https://reqres.in/api/users/2").then().statusCode(204);//delete
}
	

}
