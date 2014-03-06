package com.shikai.endpoint;

import javax.xml.ws.Endpoint;

public class ServicePublisher {
	public static void main (String[] args) throws Exception {		
		
		Endpoint.publish("http://localhost:8080/ws/Greeting", new com.shikai.api.ServicesAPI());		
	}
}
