import files.Payloads;
import files.reUsablemethods;
import io.restassured.path.json.JsonPath;

public class Complexjsonparse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Print No of courses returned by API
		
		JsonPath js=new JsonPath(Payloads.courseprice());
		
		
	       int count =js.getInt("courses.size()");
		       
				System.out.println(count);
				
				
				
				//Print Purchase Amount
				int courseamount=js.getInt("dashboard.purchaseAmount");
				System.out.println(courseamount);
				
				//Print Title of the first course
				
				String firstname=js.get("courses[0].title");
		System.out.println(firstname);
		
		//Print All course titles and their respective Prices
		
		for (int i=0;i<count;i++)
		{
			js.get("courses["+i+"].title");
			
			System.out.println(js.get("courses["+i+"].title").toString());
			
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		
		//print number of copies sold by RPA course
		
		for (int i=0;i<count;i++)
		{
			String coursetitle=js.get("courses["+i+"].title");
			
			if (coursetitle.equalsIgnoreCase("Cypress"))
			{
				int countcopies=js.get("courses["+i+"].copies");
				
				
				System.out.println("number of copies sold by cypress");
				
				System.out.println(countcopies);
				break;
	
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
