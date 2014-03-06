package com.shikai.api;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;


@WebService(endpointInterface = "com.shikai.api.ServiceBInterface", targetNamespace = "http://localhost", 
serviceName = "GoodbyeService", portName = "GoodbyePort")

public class Server2 implements ServiceBInterface{	
	
	@Resource
	WebServiceContext wsContext; 
	static int numOfReq; //number of requests handled by the server
	
	@Override
	@WebMethod
	public String goodBye(String name) {
		numOfReq++;		
		return "Goodbye " + name + "! This is the goodbye service from server 2";
	}	
	
	public int getNumOfReq() {
		return Server2.numOfReq;
	}
}

