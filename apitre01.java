package api001;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.net.http.HttpResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class apitre01 {
	String id;
	@Test(enabled=true)
	public void createboard()
	{
		RestAssured.baseURI="https://api.trello.com";
		Response rep=given()
		.queryParam("name","saranya").queryParam("key","59cdf0dce70f09ab1f87e13027fbb217")
		.queryParam("token","ATTA0503cfcbe2c171bc581ec92db3bb4bc17cb665960db547a5af2a60b71d33f69329FB73DD")
		.header("Content-Type","application/json")
		.when().post("/1/boards/").then().statusCode(200).extract().response();
		System.out.println(rep.asString());
		JsonPath js=new JsonPath(rep.asString());
		  id =js.getString("id");
		  System.out.println(id);		
		}
	//@Test(enabled=true)
	void  delete()
	{
		RestAssured.baseURI="https://api.trello.com/1/boards/"+id;
		given().queryParam("key","59cdf0dce70f09ab1f87e13027fbb217")
		.queryParam("token","ATTA0503cfcbe2c171bc581ec92db3bb4bc17cb665960db547a5af2a60b71d33f69329FB73DD")
		.header("Content-Type","application/json").when().delete().then().statusCode(200);
	}
	@Test(enabled=true)
	void update()
	{
		RestAssured.baseURI="https://api.trello.com/1/boards/{id}";
		given().queryParam("name","anu").queryParam("key","59cdf0dce70f09ab1f87e13027fbb217")
		.queryParam("token","ATTA0503cfcbe2c171bc581ec92db3bb4bc17cb665960db547a5af2a60b71d33f69329FB73DD")
		.header("Content-Type","application/json");
	}
	

}
