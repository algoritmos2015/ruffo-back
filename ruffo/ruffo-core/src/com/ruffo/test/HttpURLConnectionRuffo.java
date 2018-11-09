package com.ruffo.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class HttpURLConnectionRuffo {

	private static final String URL_BASE = "http://localhost:8080/ruffo-core-0.0.1-SNAPSHOT/usuario";
	private final static String USER_AGENT = "Mozilla/5.0";
	private final static String CREATED = "201";
	private final static String INTERNAL_SERVER_ERROR = "500";

	// HTTP GET request
	private void sendGet(String url) throws Exception {
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print result
		System.out.println(response.toString());

	}

	// HTTP POST request
	@Test
	public void sendPost() throws Exception {
		String statusCode = INTERNAL_SERVER_ERROR;
		try {
			statusCode = agregarUsuarioHTTP("pereirawg@gmail.com", "12345678", "1980-01-15 16:45", "Uruguay");
		} catch (Exception e) {
			assertEquals(INTERNAL_SERVER_ERROR, statusCode);
		}
		assertEquals(INTERNAL_SERVER_ERROR, statusCode);
	}
	
	
	public String agregarUsuarioHTTP(String email, String clave, String fechaNacimiento, String pais)
			throws Exception {
		String url = URL_BASE;
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		
		StringEntity input = new StringEntity("{\"eMail\":\"" + email+ "\", " + "\"clave\":\"" + clave + "\", "
				+ "\"fechaNacimiento\":\"" + fechaNacimiento + "\",\"pais\": \""
				+ pais + "\"" + "}");
		
		input.setContentType("application/json");
		post.setEntity(input);

		HttpResponse response = client.execute(post);
		Integer statusCode = response.getStatusLine().getStatusCode();
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return statusCode.toString();
	}

	
}
