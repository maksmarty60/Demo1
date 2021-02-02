import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	//////////////////////////first method////////////////////////////////////////
	@Test(dataProvider="addbooksdata")
	public void addbook(String isbn, String aisle)
	{
	
	/////////////////////////NEAT and CLEAN ///////////////////////////////////////////////////////////////	
		
		RestAssured.baseURI="http://216.10.245.166";
		
		
		
		String Response=given().log().all().header("Content-Type", "application/json").
				
		body(Payloads.addbook(isbn,aisle)).when().post("/Library/Addbook.php")
		
	.then().assertThat().statusCode(200).extract().response().asString();
		
		
		/*JsonPath js =new JsonPath(Response);
		
		String id =js.get("ID");
		
		System.out.println(id);*/
	
	}
	
	///////////////////////Second Methd///////////////////////////////////
	@Test(dataProvider="addbooksdata")
	public void deletebooks(String isbn, String aisle)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		
		
		
		given().log().all().header("Content-Type", "application/json").
				
		body("{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+isbn+aisle+"\"\r\n" + 
				"\r\n" + 
				"} \r\n" + 
				"\r\n" + 
				"").when().post("/Library/DeleteBook.php")
		
	.then().assertThat().statusCode(200);
		
		
	}
	
	
	@DataProvider(name="addbooksdata")
	
    public Object[][] getdata()
    {
		
		return new Object [][] {{"jkhjkjhkhjk","87878787"},{"rtyrtytyuyt","77878755"},{"bvnvbnbvmm","567676767"}};
		
    }
     
		
    }

