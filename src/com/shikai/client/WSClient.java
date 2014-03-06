package com.shikai.client;

import java.net.*;
import javax.xml.namespace.QName;
import javax.xml.ws.*;
import com.shikai.api.*;
 
public class WSClient {
	
	public static void main (String[] args) throws Exception {
		
		//One URL for all services
		URL servicesUrl = new URL("http://localhost:8080/ws/Greeting?wsdl");
		
		//Service A QName
		QName serviceAName = new QName("http://localhost", "ServicesAPIService");
		Service serviceA = Service.create(servicesUrl, serviceAName);
		
		//Service B QName
		QName serviceBName = new QName("http://localhost", "ServicesAPIService");
		Service serviceB = Service.create(servicesUrl, serviceBName);
		
		//Service A
		AllServicesInterface A = (AllServicesInterface) serviceA.getPort(AllServicesInterface.class);
		System.out.println(A.sendGreeting("Spock. Shacha"));	
				
		//Service B
		AllServicesInterface B = (AllServicesInterface) serviceB.getPort(AllServicesInterface.class);
		System.out.println(B.goodBye("Spock. Live long and prosper"));
		
		//Check API service statistics
		System.out.println(B.getStatistics());
	}
	
}
