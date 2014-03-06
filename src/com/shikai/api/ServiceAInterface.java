package com.shikai.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://localhost")

public interface ServiceAInterface {
	@WebMethod String sendGreeting (String name);	
}
