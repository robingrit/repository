import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReader {
	public static JSONObject json;

	

	public static void JsonRead(int option) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
        qrRequest qrRequest = new qrRequest();
        qrIdBean qrIdBean = new qrIdBean();
        
        String Option1 =qrRequest.request(qrIdBean.getOption1());
		String Option2 =qrRequest.request(qrIdBean.getOption2());
		String Option3 =qrRequest.request(qrIdBean.getOption3());
		
		
		if (option == 1) {
			 json = (JSONObject) parser.parse(Option1);
			ParseQr();
			
		} else if(option == 2) {
			 json = (JSONObject) parser.parse(Option2);
			ParseQr();

		}
		else {
			 json = (JSONObject) parser.parse(Option3);
			ParseQr();
			
		}
			
	}
		
		
		
		
	
	public static ArrayList<JsonBean> ParseQr() {
		
		
 
		
		JSONArray array = new JSONArray();
		
		array.add(json);
		JSONObject data =(JSONObject) json.get("data");
		JSONArray dataArray = (JSONArray) data.get("data");
		
		dataArray.size();
		
		
		ArrayList<JsonBean> qrList = new ArrayList<JsonBean>();
		
		ArrayList<String> locList = new ArrayList<String>();
		ArrayList<String> cityList = new ArrayList<String>();
		ArrayList<String> deviceList = new ArrayList<String>();
		ArrayList<String> countList = new ArrayList<String>();
		
		for (int i = 0; i < dataArray.size(); i++) {
			JSONObject JsonData =(JSONObject) dataArray.get(i);
			JSONObject _id =(JSONObject) JsonData.get("_id");
			Object count =JsonData.get("count");
			Object loc =_id.get("loc");
			Object city =_id.get("city");
			Object device =_id.get("device");
			locList.add(loc.toString());
			cityList.add(city.toString());
			if(device == null) {
				deviceList.add("unknown");
			}
			else {
			deviceList.add(device.toString());
			countList.add(count.toString());		
			//System.out.println();            
			//System.out.println("array is " + dataArray.get(i));
			}
			
		}
		for (int i = 0; i < countList.size(); i++) {
			
			String loc = locList.get(i);
			if(loc.equals("")) {
				loc = "unknown";
			}
			String city = cityList.get(i);
			if(city.equals("")) {
				city = "unknown";
			}
			String device= deviceList.get(i);
			if(device.equals("")) {
				device = "unknown";
			}
			String count = countList.get(i);
			JsonBean bean = new JsonBean(count, loc,city,device );
			qrList.add(bean);
			
		}
		
		
		 
		 return qrList;

	
	
		
	}

}
