package com.shikai.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://localhost")

public interface AllServicesInterface extends ServiceAInterface, ServiceBInterface{
	@WebMethod String getStatistics ();	
	@WebMethod public int rand(int min, int max);
}
