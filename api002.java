package api001;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class api002 {
	@Test
	
	public void method01()
	{
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody());
		System.out.println(res.asString());
		 Assert.assertEquals(200,res.getStatusCode());
		 System.out.println("passed");
	}
	

}
