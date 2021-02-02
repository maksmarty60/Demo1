import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Addplace {
	
public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String Response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payloads.addplace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		
		System.out.println(Response);
		
		
		JsonPath js = new JsonPath(Response);
		String placeid=js.getString("place_id");
		
		System.out.println(placeid);
		
		//Update call
		
		String newaddress = "London United Kingdom";
		 
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\n" + 
			"\"place_id\":\""+placeid+"\",\n" + 
			"\"address\":\""+newaddress+"\",\n" + 
			"\"key\":\"qaclick123\"\n" + 
			"}\n" + 
			"").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get call
		
		String GetPlaceresponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeid)
		.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(GetPlaceresponse);
              String jsonaddress=js1.getString("address");		
		System.out.println(jsonaddress);
		
		Assert.assertEquals(jsonaddress, newaddress);
		
	}

//add the place -> update place with new address -> get place to validate if new address is present in response or not

     



}
