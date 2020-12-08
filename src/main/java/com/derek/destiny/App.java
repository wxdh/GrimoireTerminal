package com.derek.destiny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class App 
{
    public static void main( String[] args )
    {
	    String apiRoot = "https://www.bungie.net/d1/platform";
	    
	    //Actual API Key. Will be disabled in future and replaced with one we keep outside the repo.
	    String apiKey = System.getProperty("API_Key");
	    if (apiKey == null)
	    	apiKey = "aac201bb2454425b9502162b2d9d5ee2";
	    
	    //url is the second half of the url we will request from
	    String url = System.getProperty("URI");
	    if(url == null)
	    {
		    SendRequest(url, apiKey);
		    System.exit(0);
	    }
	    String apiPath = "/Destiny/Manifest/InventoryItem/1274330687/";
	    url = apiRoot + apiPath;
	    SendRequest(url, apiKey);
	
		/*
		Found at http://destinydevs.github.io/BungieNetPlatform/docs/Getting-Started
	
		We can use the code sample for java to get started and test things out.
		
		Official Documentation can be found at https://bungie-net.github.io/	
		From there I'm not sure where to go yet. I've combed through it a little bit and 
		found the closest thing might be "Records" in https://bungie-net.github.io/multi/schema_Destiny-DestinyComponentType.html
		*/
    }

    public static void SendRequest(String url, String key)
    {
// Method 2: java.net.http.HttpClient (Async and handle Asynchronous options for you)
        HttpClient client = HttpClient.newHttpClient();
        // Building our request with Destiny's url for obtaining lore as JSON
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .timeout(Duration.ofMillis(5000))
                        .header("X-API-KEY", key)
                        .build();

        // Send the request asynchronously with our client. Full streamline operation
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()) // Receive the response body as a string (1st result), will return a CompletableFuture data type
                .thenApply(HttpResponse::body) // Apply the body method of HttpResponse class on the previous result
                .thenAccept(System.out::println) // Use print on the previous result which is the body
                .join(); // join() gets result to console
    }
}
