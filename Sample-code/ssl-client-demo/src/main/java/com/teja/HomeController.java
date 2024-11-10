package com.teja;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
	

	HttpClient httpClient;
	public HomeController(HttpClient httpClient) {

		this.httpClient = httpClient;
	}
	
	
	//below end point is to call external api which is a https based (ssl-sever-demo app)
	@GetMapping("/server")
	public String getServer() throws URISyntaxException, ClientProtocolException, IOException, InterruptedException {
		
       var request=HttpRequest.newBuilder().GET().uri(new URI("https://localhost:8443/hello")).build();
       HttpResponse<String> response= httpClient.send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(response.body() +"   "+ response.statusCode());
	
       return response.body();		 	  
		   
    }
	@GetMapping("/dummy")
	public String getDummy(){
		return "dummy value";
	}
	
	
	
	@GetMapping("/myhome")
	public String getMyhome() {
		
		return "myhome-server";
	}
	

}
