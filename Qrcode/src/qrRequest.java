import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class qrRequest {
	static String jsonString;
	
	public static String request(String QrId)throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://qrtiger.com/data/"+QrId+"?period=month&tz=Asia%2FSingapore"))
			    .header("Content-Type", "application/json")
			    .header("Authorization", "Bearer ca6001d0-3a8e-11ed-bef2-4f7ed9507b57")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			jsonString = response.body();
			
			
			return jsonString;

	}
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
			
		//JsonBean bean = new JsonBean(request("44JO"), request("44JO"), request("44JO"));
		
		
		
		
		

	}

}
