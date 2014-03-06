package com.shikai.api;

import java.net.InetSocketAddress;
import java.net.URL;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.xml.internal.ws.developer.JAXWSProperties;

@WebService(endpointInterface = "com.shikai.api.AllServicesInterface", targetNamespace = "http://localhost")


public class ServicesAPI implements AllServicesInterface {
	
	@Resource
	WebServiceContext wsContext; 
	
	ServiceAInterface intA1, intA3;
	ServiceBInterface intB2, intB4;	
	int serverAssign;
	static int totalNumOfRequests;
		
	public ServicesAPI() throws Exception {	
		
		//Service A, server 1
		URL serviceA1Url = new URL("http://localhost:8081/ws/Greeting?wsdl");
		QName serviceAName = new QName("http://localhost", "GreetingService");		
		Service serviceA1 = Service.create(serviceA1Url, serviceAName);		
		intA1 = serviceA1.getPort(ServiceAInterface.class);
		
		//Service A, server 3
		URL serviceA3Url = new URL("http://localhost:8083/ws/Greeting?wsdl");		
		Service serviceA3 = Service.create(serviceA3Url, serviceAName);		
		intA3 = serviceA3.getPort(ServiceAInterface.class);
		
		//Service B, server 2
		URL serviceB2Url = new URL("http://localhost:8082/ws/Goodbye?wsdl");
		QName serviceBName = new QName("http://localhost", "GoodbyeService");		
		Service serviceB2 = Service.create(serviceB2Url, serviceBName);		
		intB2 = serviceB2.getPort(ServiceBInterface.class);
		
		//Service B, server 4
		URL serviceB4Url = new URL("http://localhost:8084/ws/Goodbye?wsdl");		
		Service serviceB4 = Service.create(serviceB4Url, serviceBName);		
		intB4 = serviceB4.getPort(ServiceBInterface.class);		
	}	
	
	public String sendGreeting(String name) {	
		
		totalNumOfRequests++;
		serverAssign = this.rand(1, 2);
		if (serverAssign == 1)
			return intA1.sendGreeting(name);
		else if (serverAssign == 2)
			return intA3.sendGreeting(name);
		else
			return "Random number out of bound";
	}	
	
	public String goodBye(String name) {
				
		totalNumOfRequests++;
		serverAssign = this.rand(1, 2);
		if (serverAssign == 1)
			return intB2.goodBye(name);
		else if (serverAssign == 2)
			return intB4.goodBye(name);
		else
			return "Random number out of bound";
	}
	
	@WebMethod
	public String getStatistics() {		
		
		MessageContext mc = wsContext.getMessageContext();
		HttpExchange exchange = (HttpExchange)mc.get(JAXWSProperties.HTTP_EXCHANGE);
		InetSocketAddress remoteAddress = exchange.getRemoteAddress();			
		
		String clientInfo = "Client IP: "+remoteAddress.getHostName()+"\nClient port: "+remoteAddress.getPort()+
				            "\nTotal number of requests served: " + totalNumOfRequests;

		return clientInfo;
	}	
	
	public int rand(int min, int max) {
		
		int randomNum = min + (int)(Math.random() * ((max - min) + 1));		
		
		return randomNum;
	}
}



