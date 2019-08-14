package com.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public class APIClient {

	public String callApi(String methodName, String url, String jsonPost)
	{
		String apiResponse = "";
		if(methodName== "GET") {
			apiResponse = callGetRequest(url);
		}
		if(methodName== "PUT") {
			//apiResponse = callPutRequest(url, jsonPost  );
		}
		if(methodName== "PATCH") {
			apiResponse = callPatchRequest(url,jsonPost );
		}
		
		return apiResponse;
	}
	
	private String callGetRequest(String url) {
		String responseText = "";
		HttpClient httpClient = new HttpClient();
		
		GetMethod httpGet = new GetMethod(url);
		try {
			httpGet.addRequestHeader("Authorization", "Bearer 374e8289-2cbc-37f4-9aab-fc21af4336fa");
			httpClient.executeMethod(httpGet);
			int c = httpGet.getStatusCode();
			
			System.out.println(c);
			
			StringBuilder result = new StringBuilder();
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpGet.getResponseBodyAsStream()));
		      String line;
		      while ((line = rd.readLine()) != null) {
		         result.append(line);
		      }
		      rd.close();
		       responseText = result.toString();
		      		      
		}
		catch(Exception e)
		{
			System.out.println();
		}
		finally {
			httpGet.releaseConnection();
		}
		
		return responseText;
	}
	
	
public String callPutRequest(String url,  JSONObject jsonPost) {
		
	String responseText = "";
	DefaultHttpClient httpClient = new DefaultHttpClient();
	
	HttpPut httpPut = new HttpPut(url);
	try {
		httpPut.setHeader("Authorization", "Bearer 374e8289-2cbc-37f4-9aab-fc21af4336fa");
		httpPut.setHeader("Content-Type", "application/json");
		 
		StringEntity se = new StringEntity(jsonPost.toString());
       //  se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		httpPut.setEntity(se);
		HttpResponse httpResponse= httpClient.execute(httpPut);
		
		int c = httpResponse.getStatusLine().getStatusCode();
		
		System.out.println(c);
		
		StringBuilder result = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	       responseText = result.toString();
	      		      
	}
	catch(Exception e)
	{
		System.out.println();
	}
	finally {
		httpClient.getConnectionManager().shutdown();
	}
	
	return responseText;
		
	}

private String callPatchRequest(String url, String jsonPost) {
	
	return "";
	
}

	
}
