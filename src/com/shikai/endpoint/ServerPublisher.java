package com.shikai.endpoint;

import javax.xml.ws.Endpoint;

public class ServerPublisher {
	public static void main (String[] args) throws Exception {		
		
		//Service A
		Endpoint.publish("http://localhost:8081/ws/Greeting", new com.shikai.api.Server1());
		Endpoint.publish("http://localhost:8083/ws/Greeting", new com.shikai.api.Server3());
		
		//Service B
		Endpoint.publish("http://localhost:8082/ws/Goodbye", new com.shikai.api.Server2());
		Endpoint.publish("http://localhost:8084/ws/Goodbye", new com.shikai.api.Server4());
	}
}
