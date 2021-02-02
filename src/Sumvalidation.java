import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payloads;
import io.restassured.path.json.JsonPath;

public class Sumvalidation {
	
	@Test
	
	public void sumvalidate()
	{
		int sum =0;
		
		JsonPath js=new JsonPath(Payloads.courseprice());
		
		
	       int size =js.getInt("courses.size()");
	       
	       for (int i=0;i<size;i++)
	       {
	    	     int price=js.getInt("courses["+i+"].price");
	    	   
	    	     int copies=js.getInt("courses["+i+"].copies");
	    	     
	    	     int totalexpense = price * copies;
	    	     
	    	     System.out.println(totalexpense);
	    	     
	    	     sum = sum + totalexpense;
	    	     //System.out.println(sum);
	       }
	       System.out.println(sum);
	       
	       
	       int purcharsetotal=js.getInt("dashboard.purchaseAmount");
  	     
   	    Assert.assertEquals(sum, purcharsetotal);
		       
		
		
	}
	

}
