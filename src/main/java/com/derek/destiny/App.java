package com.derek.destiny;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "This Destiny lore terminal access is gonna be lit!!!" );

	String apiRoot = "https://www.bungie.net/Platform";

	//Actual API Key. Will be disabled in future and replaced with one we keep outside the repo.
	String apiKey = "aac201bb2454425b9502162b2d9d5ee2";

	//url is the second half of the url we will request from.
	String apiPath = "/something/lore";
	String url = apiRoot + apiPath;

	/*
	Found at http://destinydevs.github.io/BungieNetPlatform/docs/Getting-Started

	We can use the code sample for java to get started and test things out.
	
	Official Documentation can be found at https://bungie-net.github.io/	
	From there I'm not sure where to go yet. I've combed through it a little bit and 
	found the closest thing might be "Records" in https://bungie-net.github.io/multi/schema_Destiny-DestinyComponentType.html
	*/
    }
}
