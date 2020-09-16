package com.java.spring.mongoDB.traceInformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class TraceInformation {
	
	public static ArrayList<Trace> arrayList = new ArrayList<Trace>();

	@RequestMapping("/information")
	public static String loadJson () {
		String url = "http://localhost:8082/actuator/httptrace";
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine = null;
			while ( (inputLine = in.readLine()) != null) {
				//System.out.println(inputLine);
				json.append(inputLine);
			}
			JSONObject json123 = JSONObject.fromObject(json.toString());       
			//System.out.println(json123.getJSONArray("traces").get(0));
			JSONArray transitListArray = json123.getJSONArray("traces");
			for (int i = 0; i < transitListArray.size(); i++  ) {
				JSONObject info = transitListArray.getJSONObject(i);// 獲取traces陣列的第i個json物件  
				String timeStamp = info.getString("timestamp");// 找到json物件裡的timestamp欄位值  
				String timeTaken = info.getString("timeTaken");
				System.out.println(timeStamp);
				System.out.println(timeTaken);
				
				JSONObject request = info.getJSONObject("request");
				String request_method = request.getString("method");
				String request_uri = request.getString("uri");
				System.out.println(request_method);
				System.out.println(request_uri);
				
				JSONObject response = info.getJSONObject("response");
				String response_status = response.getString("status");
				System.out.println(response_status);
				
				Trace trace = new Trace();
				trace.setTimeStamp(timeStamp);
				trace.setTimeTaken(timeTaken);
				trace.setRequest_method(request_method);
				trace.setRequest_uri(request_uri);
				trace.setResponse_status(response_status);
				arrayList.add(trace);
				System.out.println(arrayList);
				//System.out.println(arrayList.get(0).getRequest_uri());
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
		}
}
