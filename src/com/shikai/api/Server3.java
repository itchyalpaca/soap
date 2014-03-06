package com.shikai.api;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;


@WebService(endpointInterface = "com.shikai.api.ServiceAInterface", targetNamespace = "http://localhost", 
serviceName = "GreetingService", portName = "GreetingPort")

public class Server3 implements ServiceAInterface{	
	
	@Resource
	WebServiceContext wsContext; 
	static int numOfReq; //number of requests handled by the server
	
	@Override
	@WebMethod
	public String sendGreeting(String name) {
		numOfReq++;		
		return "Hello " + name + "! This is the greeting service from server 3";
	}	
	
	public int getNumOfReq() {
		return Server3.numOfReq;
	}
}

