package apiTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiResponseFetch {

	public static void main(String[] args) {
		// inline will store the JSON data streamed in string format
		String inline = "";
		String city = "faridabad";
		String token = "e5cc547bc364ca34ee993d777d03a7773d1f2f0c";

		try {
			
			// URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221");
			URL url = new URL("https://api.waqi.info/search/?token=" +token+ "&keyword=" +city);
			
			// Parse URL into HttpURLConnection in order to open the connection in order to
			// get the JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// Set the request to GET or POST as per the requirements
			conn.setRequestMethod("GET");
			
			// Use the connect method to create the connection bridge
			conn.connect();
			
			// Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			// Iterating condition to if response code is not 200 then throw a runtime
			// exception
			// else continue the actual process of getting the JSON data
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				// Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				//System.out.println("\nJSON Response in String format");
				//System.out.println(inline);
				// Close the stream when reading the data has been finished
				sc.close();
			}

			// JSONParser reads the data from string object and break each data into key
			// value pairs
			JSONParser parse = new JSONParser();

			// Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject) parse.parse(inline);

			// Store the JSON object in JSON array as objects (For level 1 array element i.e
			// Results)
			JSONArray jsonarr_1 = (JSONArray) jobj.get("data");

			// Get data for Results array
			for (int i = 0; i < jsonarr_1.size(); i++) {
				// Store the JSON objects in an array
				// Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);

				System.out.println("Elements under results array");
				System.out.println("\nAir Quality Index: " + jsonobj_1.get("aqi"));
				System.out.println("\nUid: " + jsonobj_1.get("uid"));
				Map address = ((Map) jsonobj_1.get("station"));

				// iterating address Map
				System.out.println(address.get("name"));

			}
			// Disconnect the HttpURLConnection stream
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
