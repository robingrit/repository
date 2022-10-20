import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReader {

	private static JSONObject scans;

	public static void main(String[] args)throws FileNotFoundException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
        qrRequest qrRequest = new qrRequest();
        qrIdBean qrIdBean = new qrIdBean();
        
        qrIdBean.getOption1();
		
		String Option1 =qrRequest.request(qrIdBean.getOption1());
		String Option2 =qrRequest.request(qrIdBean.getOption2());
		String Option3 =qrRequest.request(qrIdBean.getOption3());
		
		JSONObject json = (JSONObject) parser.parse(Option1); 
		//Object obj  = parser.parse((new FileReader("C:\\Users\\zorpi\\eclipse-workspace\\Qrcode\\src\\Qrjson.json")));
		JSONArray array = new JSONArray();
		
		array.add(json);
		
		 for (Object o : array)
		  {
			 
			
		    JSONObject person = (JSONObject) o;
		    JSONObject data =(JSONObject) person.get("data");
		    System.out.println(data);
		    
		    String Scans =(String) data.get("scans").toString(); 
		  
		     
		   
		    
		    System.out.println(Scans);

		    
		    
		    
		   

		
		    
		    

		    

		    
		  }

	}

}
